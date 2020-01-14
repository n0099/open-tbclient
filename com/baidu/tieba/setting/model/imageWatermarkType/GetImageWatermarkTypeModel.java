package com.baidu.tieba.setting.model.imageWatermarkType;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.i;
import com.baidu.tieba.setting.more.MoreActivity;
/* loaded from: classes11.dex */
public class GetImageWatermarkTypeModel extends BdBaseModel<MoreActivity> {
    private HttpMessageListener jQH;

    public GetImageWatermarkTypeModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.jQH = new HttpMessageListener(CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE) { // from class: com.baidu.tieba.setting.model.imageWatermarkType.GetImageWatermarkTypeModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof GetImageWatermarkTypeResMsg) {
                    GetImageWatermarkTypeResMsg getImageWatermarkTypeResMsg = (GetImageWatermarkTypeResMsg) httpResponsedMessage;
                    if (getImageWatermarkTypeResMsg.mMaskType > -1) {
                        i.axy().setImageWaterType(getImageWatermarkTypeResMsg.mMaskType);
                    }
                }
            }
        };
        registerListener(this.jQH);
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
