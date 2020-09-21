package com.baidu.tieba.livesdk.share.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.livesdk.share.message.AlaShareInBarResponsedMessage;
/* loaded from: classes4.dex */
public class AlaShareInBarModel extends BdBaseModel {
    private a kdo;
    private final HttpMessageListener kdp = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.tieba.livesdk.share.model.AlaShareInBarModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaShareInBarResponsedMessage)) {
                AlaShareInBarResponsedMessage alaShareInBarResponsedMessage = (AlaShareInBarResponsedMessage) httpResponsedMessage;
                if (AlaShareInBarModel.this.kdo != null) {
                    AlaShareInBarModel.this.kdo.a(alaShareInBarResponsedMessage.getError(), alaShareInBarResponsedMessage.getErrorString(), alaShareInBarResponsedMessage.getShareInBarData());
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.livesdk.share.b.a aVar);
    }

    public AlaShareInBarModel() {
        cRE();
        MessageManager.getInstance().registerListener(this.kdp);
    }

    private void cRE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_LIVE_SHARE_IN_BAR);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaShareInBarResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void au(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("forum_ids", str2);
        httpMessage.addParam("content", str3);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void a(a aVar) {
        this.kdo = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
        MessageManager.getInstance().unRegisterListener(this.kdp);
    }
}
