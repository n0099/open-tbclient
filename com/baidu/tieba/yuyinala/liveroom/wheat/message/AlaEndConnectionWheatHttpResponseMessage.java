package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEndConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String nYB;
    private int nYC;
    private int nYD;

    public AlaEndConnectionWheatHttpResponseMessage() {
        super(1031011);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031011 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.nYB = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.nYC = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.nYD = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean dWY() {
        return this.nYD == 1 || this.nYD == 2 || this.nYD == 3;
    }

    public String dWZ() {
        return this.nYB;
    }

    public int cUk() {
        return this.fans;
    }

    public int dXa() {
        return this.nYC;
    }
}
