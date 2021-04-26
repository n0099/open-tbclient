package com.baidu.tieba.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VideoHolyCardResponseMessage extends JsonHttpResponsedMessage {
    public boolean isVideoHolyCard;

    public VideoHolyCardResponseMessage() {
        super(CmdConfigHttp.CMD_VIDEO_HOLY_CARD);
        this.isVideoHolyCard = false;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.isVideoHolyCard = jSONObject.optInt("data") == 1;
        }
    }
}
