package com.baidu.tieba.livesdk.share.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.livesdk.share.message.AlaShareInBarResponsedMessage;
/* loaded from: classes3.dex */
public class AlaShareInBarModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f18817e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f18818f = new a(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof AlaShareInBarResponsedMessage)) {
                return;
            }
            AlaShareInBarResponsedMessage alaShareInBarResponsedMessage = (AlaShareInBarResponsedMessage) httpResponsedMessage;
            if (AlaShareInBarModel.this.f18817e != null) {
                AlaShareInBarModel.this.f18817e.a(alaShareInBarResponsedMessage.getError(), alaShareInBarResponsedMessage.getErrorString(), alaShareInBarResponsedMessage.getShareInBarData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2, String str, d.a.j0.m1.l.b.a aVar);
    }

    public AlaShareInBarModel() {
        t();
        MessageManager.getInstance().registerListener(this.f18818f);
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
        MessageManager.getInstance().unRegisterListener(this.f18818f);
    }

    public final void t() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_LIVE_SHARE_IN_BAR);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaShareInBarResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void u(String str, String str2, String str3, String str4) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR);
        if (TextUtils.isEmpty(str2)) {
            httpMessage.addParam("live_id", str);
        } else {
            httpMessage.addParam(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID, str2);
        }
        httpMessage.addParam("forum_ids", str3);
        httpMessage.addParam("content", str4);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(b bVar) {
        this.f18817e = bVar;
    }
}
