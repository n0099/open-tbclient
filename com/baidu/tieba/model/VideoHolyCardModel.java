package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.message.VideoHolyCardResponseMessage;
/* loaded from: classes3.dex */
public class VideoHolyCardModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f18729e;

    /* renamed from: f  reason: collision with root package name */
    public long f18730f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessageListener f18731g = new a(CmdConfigHttp.CMD_VIDEO_HOLY_CARD);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof VideoHolyCardResponseMessage) || VideoHolyCardModel.this.f18729e == null) {
                return;
            }
            VideoHolyCardModel.this.f18729e.onResult(((VideoHolyCardResponseMessage) httpResponsedMessage).isVideoHolyCard);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onResult(boolean z);
    }

    public VideoHolyCardModel() {
        u();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void t() {
        if (System.currentTimeMillis() - this.f18730f <= 200) {
            return;
        }
        String clientIP = UtilHelper.getClientIP();
        int networkOperator = UtilHelper.getNetworkOperator();
        String str = networkOperator == 1 ? "CMNET" : networkOperator == 2 ? "UNICOM" : networkOperator == 3 ? "TELECOM" : RomUtils.UNKNOWN;
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            this.f18729e.onResult(false);
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_HOLY_CARD);
        httpMessage.addParam("localip", clientIP);
        httpMessage.addParam("network", str);
        MessageManager.getInstance().sendMessage(httpMessage);
        this.f18730f = System.currentTimeMillis();
    }

    public final void u() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_HOLY_CARD, TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_HOLY_CARD);
        tbHttpMessageTask.setResponsedClass(VideoHolyCardResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f18731g);
    }

    public void v(b bVar) {
        this.f18729e = bVar;
    }
}
