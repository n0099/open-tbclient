package com.baidu.tieba.realauthen.a;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.realauthen.message.RealAuthenCertifyInfoResponseMessage;
import com.baidu.tieba.realauthen.message.RealAuthenSpResponseMessage;
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private b kIC;
    private HttpMessageListener kIH = new HttpMessageListener(1021148) { // from class: com.baidu.tieba.realauthen.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof RealAuthenSpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && a.this.kIC != null) {
                a.this.kIC.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener kII = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY) { // from class: com.baidu.tieba.realauthen.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof RealAuthenCertifyInfoResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && a.this.kIC != null) {
                a.this.kIC.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    public a(b bVar) {
        this.kIC = bVar;
        Fv();
        registerListener(this.kIH);
        registerListener(this.kII);
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021148, TbConfig.SERVER_HOST + "feedvideoui/ugc/getbaiduyunspparams");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(RealAuthenSpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY, TbConfig.SERVER_HOST + "feedvideoui/ugc/getbaiduyuncertifyinfo");
        tbHttpMessageTask2.setIsNeedLogin(false);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(RealAuthenCertifyInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void cTW() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021148));
    }

    public void C(String str, String str2, String str3, String str4) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
        httpMessage.addParam("uid", str);
        httpMessage.addParam("bid", str);
        httpMessage.addParam("callbackkey", str2);
        httpMessage.addParam("user_name", str3);
        httpMessage.addParam("user_id_card", str4);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
