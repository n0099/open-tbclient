package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaEndConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String oLC;
    private int oLD;
    private int oLE;

    public AlaEndConnectionWheatHttpResponseMessage() {
        super(1031011);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031011 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oLC = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.oLD = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.oLE = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean eeJ() {
        return this.oLE == 1 || this.oLE == 2 || this.oLE == 3;
    }

    public String eeK() {
        return this.oLC;
    }

    public int cZC() {
        return this.fans;
    }

    public int eeL() {
        return this.oLD;
    }
}
