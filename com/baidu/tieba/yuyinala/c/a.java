package com.baidu.tieba.yuyinala.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.message.AlaLootRedPacketResultResponseMessage;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private HttpMessageListener hHY;
    private f ohM;

    public a(BdPageContext<?> bdPageContext, f fVar) {
        super(bdPageContext);
        this.hHY = new HttpMessageListener(1031075) { // from class: com.baidu.tieba.yuyinala.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031075 && (httpResponsedMessage instanceof AlaLootRedPacketResultResponseMessage)) {
                    AlaLootRedPacketResultResponseMessage alaLootRedPacketResultResponseMessage = (AlaLootRedPacketResultResponseMessage) httpResponsedMessage;
                    if (a.this.ohM != null) {
                        if (alaLootRedPacketResultResponseMessage.getError() != 0 || !alaLootRedPacketResultResponseMessage.isSuccess()) {
                            a.this.ohM.t(alaLootRedPacketResultResponseMessage.getError(), alaLootRedPacketResultResponseMessage.getErrorString());
                        } else {
                            a.this.ohM.b(alaLootRedPacketResultResponseMessage.egs());
                        }
                    }
                }
            }
        };
        this.ohM = fVar;
        initTasks();
        registerListener(this.hHY);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031075, TbConfig.SERVER_HOST + "liveserver/redpacket/getredpacketresultlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaLootRedPacketResultResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void av(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1031075);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("redpacket_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("anchor_id", str3);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hHY);
        MessageManager.getInstance().unRegisterTask(1031075);
    }
}
