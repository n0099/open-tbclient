package com.baidu.tieba.realauthen.a;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.realauthen.message.RealAuthenCertifyInfoResponseMessage;
import com.baidu.tieba.realauthen.message.RealAuthenSpResponseMessage;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private b mmq;
    private HttpMessageListener mmu = new HttpMessageListener(1021148) { // from class: com.baidu.tieba.realauthen.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof RealAuthenSpResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && a.this.mmq != null) {
                a.this.mmq.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };
    private HttpMessageListener mmv = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY) { // from class: com.baidu.tieba.realauthen.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof RealAuthenCertifyInfoResponseMessage) && httpResponsedMessage.getOrginalMessage() != null && a.this.mmq != null) {
                a.this.mmq.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    public a(b bVar) {
        this.mmq = bVar;
        registerTask();
        registerListener(this.mmu);
        registerListener(this.mmv);
    }

    private void registerTask() {
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

    public void dxw() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021148));
    }

    public void H(String str, String str2, String str3, String str4) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
        httpMessage.addParam("uid", str);
        httpMessage.addParam(MapBundleKey.MapObjKey.OBJ_BID, str);
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
