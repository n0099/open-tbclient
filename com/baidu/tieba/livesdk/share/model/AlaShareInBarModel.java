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
/* loaded from: classes3.dex */
public class AlaShareInBarModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f18444e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f18445f = new a(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof AlaShareInBarResponsedMessage)) {
                return;
            }
            AlaShareInBarResponsedMessage alaShareInBarResponsedMessage = (AlaShareInBarResponsedMessage) httpResponsedMessage;
            if (AlaShareInBarModel.this.f18444e != null) {
                AlaShareInBarModel.this.f18444e.a(alaShareInBarResponsedMessage.getError(), alaShareInBarResponsedMessage.getErrorString(), alaShareInBarResponsedMessage.getShareInBarData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str, d.b.i0.m1.k.b.a aVar);
    }

    public AlaShareInBarModel() {
        t();
        MessageManager.getInstance().registerListener(this.f18445f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
        MessageManager.getInstance().unRegisterListener(this.f18445f);
    }

    public final void t() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_LIVE_SHARE_IN_BAR);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaShareInBarResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void u(String str, String str2, String str3) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("forum_ids", str2);
        httpMessage.addParam("content", str3);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(b bVar) {
        this.f18444e = bVar;
    }
}
