package com.baidu.tieba.setting.model.imageWatermarkType;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetImageWatermarkTypeResMsg extends JsonHttpResponsedMessage {
    public static final int INVALID_TYPE = -1;
    public int mMaskType;

    public GetImageWatermarkTypeResMsg() {
        super(CmdConfigHttp.CMD_GET_IMAGE_WATERMARK_TYPE);
        this.mMaskType = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        this.mMaskType = jSONObject.getInt("data");
    }
}
