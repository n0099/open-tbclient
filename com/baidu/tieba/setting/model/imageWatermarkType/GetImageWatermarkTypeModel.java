package com.baidu.tieba.setting.model.imageWatermarkType;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.i;
import com.baidu.tieba.setting.more.MoreActivity;
/* loaded from: classes13.dex */
public class GetImageWatermarkTypeModel extends BdBaseModel<MoreActivity> {
    private HttpMessageListener jRE;

    public GetImageWatermarkTypeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jRE = new HttpMessageListener(CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE) { // from class: com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetImageWatermarkTypeResMsg) {
                    GetImageWatermarkTypeResMsg getImageWatermarkTypeResMsg = (GetImageWatermarkTypeResMsg) httpResponsedMessage;
                    if (getImageWatermarkTypeResMsg.mMaskType > -1) {
                        i.azO().setImageWaterType(getImageWatermarkTypeResMsg.mMaskType);
                    }
                }
            }
        };
        registerListener(this.jRE);
        LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE));
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
