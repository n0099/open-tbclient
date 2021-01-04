package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaEndConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String oDU;
    private int oDV;
    private int oDW;

    public AlaEndConnectionWheatHttpResponseMessage() {
        super(1031011);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031011 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oDU = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.oDV = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.oDW = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean efW() {
        return this.oDW == 1 || this.oDW == 2 || this.oDW == 3;
    }

    public String efX() {
        return this.oDU;
    }

    public int dbh() {
        return this.fans;
    }

    public int efY() {
        return this.oDV;
    }
}
