package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLinkCallBackHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String owX;
    private int owY;
    private int owZ;

    public AlaLinkCallBackHttpResponseMessage() {
        super(1031027);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031027 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.owX = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.owY = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.owZ = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean efM() {
        return this.owZ == 1 || this.owZ == 2 || this.owZ == 3;
    }

    public String efN() {
        return this.owX;
    }

    public int dbD() {
        return this.fans;
    }

    public int efO() {
        return this.owY;
    }
}
