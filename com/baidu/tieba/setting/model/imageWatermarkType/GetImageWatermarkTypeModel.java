package com.baidu.tieba.setting.model.imageWatermarkType;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.setting.more.MoreActivity;
import d.a.n0.r.k;
/* loaded from: classes5.dex */
public class GetImageWatermarkTypeModel extends BdBaseModel<MoreActivity> {

    /* renamed from: e  reason: collision with root package name */
    public HttpMessageListener f20574e;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(GetImageWatermarkTypeModel getImageWatermarkTypeModel, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetImageWatermarkTypeResMsg) {
                GetImageWatermarkTypeResMsg getImageWatermarkTypeResMsg = (GetImageWatermarkTypeResMsg) httpResponsedMessage;
                if (getImageWatermarkTypeResMsg.mMaskType > -1) {
                    k.c().i(getImageWatermarkTypeResMsg.mMaskType);
                }
            }
        }
    }

    public GetImageWatermarkTypeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        a aVar = new a(this, CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE);
        this.f20574e = aVar;
        registerListener(aVar);
        LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE));
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
