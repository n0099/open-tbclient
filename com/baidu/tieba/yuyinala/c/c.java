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
import com.baidu.tieba.yuyinala.message.AlaGetRedPacketInfoResponseMessage;
import com.baidu.tieba.yuyinala.message.AlaSnatchRedPacketResponseMessage;
/* loaded from: classes11.dex */
public class c extends BdBaseModel {
    private HttpMessageListener hUg;
    private HttpMessageListener hUh;
    private a opv;

    /* loaded from: classes11.dex */
    public interface a {
        void aW(int i, String str);

        void aX(int i, String str);

        void b(com.baidu.tieba.yuyinala.data.a aVar);

        void b(com.baidu.tieba.yuyinala.data.f fVar);
    }

    public c(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.hUg = new HttpMessageListener(1031073) { // from class: com.baidu.tieba.yuyinala.c.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031073 && (httpResponsedMessage instanceof AlaGetRedPacketInfoResponseMessage)) {
                    AlaGetRedPacketInfoResponseMessage alaGetRedPacketInfoResponseMessage = (AlaGetRedPacketInfoResponseMessage) httpResponsedMessage;
                    if (c.this.opv != null) {
                        if (alaGetRedPacketInfoResponseMessage.getError() != 0 || !alaGetRedPacketInfoResponseMessage.isSuccess()) {
                            c.this.opv.aW(alaGetRedPacketInfoResponseMessage.getError(), alaGetRedPacketInfoResponseMessage.getErrorString());
                        } else {
                            c.this.opv.b(alaGetRedPacketInfoResponseMessage.efE());
                        }
                    }
                }
            }
        };
        this.hUh = new HttpMessageListener(1031074) { // from class: com.baidu.tieba.yuyinala.c.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031074 && (httpResponsedMessage instanceof AlaSnatchRedPacketResponseMessage)) {
                    AlaSnatchRedPacketResponseMessage alaSnatchRedPacketResponseMessage = (AlaSnatchRedPacketResponseMessage) httpResponsedMessage;
                    if (c.this.opv != null) {
                        com.baidu.tieba.yuyinala.data.f efH = alaSnatchRedPacketResponseMessage.efH();
                        if (alaSnatchRedPacketResponseMessage.getError() != 0 || !alaSnatchRedPacketResponseMessage.isSuccess()) {
                            c.this.opv.aX(alaSnatchRedPacketResponseMessage.getError(), alaSnatchRedPacketResponseMessage.getErrorString());
                        } else {
                            c.this.opv.b(efH);
                        }
                    }
                }
            }
        };
        this.opv = aVar;
        initTasks();
        registerListener(this.hUg);
        registerListener(this.hUh);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031073, TbConfig.SERVER_HOST + "liveserver/redpacket/getredpacketinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetRedPacketInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031074, TbConfig.SERVER_HOST + "liveserver/redpacket/lootredpacket");
        tbHttpMessageTask2.setIsNeedLogin(true);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(AlaSnatchRedPacketResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void az(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1031073);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("redpacket_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("anchor_uk", str3);
        httpMessage.addParam("is_jiaoyou", 1);
        sendMessage(httpMessage);
    }

    public void aA(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(1031074);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        httpMessage.addParam("redpacket_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("anchor_uk", str3);
        httpMessage.addParam("is_jiaoyou", 1);
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
        MessageManager.getInstance().unRegisterListener(this.hUh);
        MessageManager.getInstance().unRegisterListener(this.hUg);
        MessageManager.getInstance().unRegisterTask(1031074);
        MessageManager.getInstance().unRegisterTask(1031073);
    }
}
