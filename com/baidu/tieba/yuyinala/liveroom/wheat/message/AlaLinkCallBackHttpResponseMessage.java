package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLinkCallBackHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String owZ;
    private int oxa;
    private int oxb;

    public AlaLinkCallBackHttpResponseMessage() {
        super(1031027);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031027 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.owZ = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.oxa = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.oxb = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean efN() {
        return this.oxb == 1 || this.oxb == 2 || this.oxb == 3;
    }

    public String efO() {
        return this.owZ;
    }

    public int dbE() {
        return this.fans;
    }

    public int efP() {
        return this.oxa;
    }
}
