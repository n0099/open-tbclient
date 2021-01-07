package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaEndConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String oDT;
    private int oDU;
    private int oDV;

    public AlaEndConnectionWheatHttpResponseMessage() {
        super(1031011);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031011 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oDT = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.oDU = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.oDV = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean efX() {
        return this.oDV == 1 || this.oDV == 2 || this.oDV == 3;
    }

    public String efY() {
        return this.oDT;
    }

    public int dbi() {
        return this.fans;
    }

    public int efZ() {
        return this.oDU;
    }
}
