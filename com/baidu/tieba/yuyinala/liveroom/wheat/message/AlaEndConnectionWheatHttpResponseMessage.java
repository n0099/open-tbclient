package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEndConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String ohX;
    private int ohY;
    private int ohZ;

    public AlaEndConnectionWheatHttpResponseMessage() {
        super(1031011);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031011 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ohX = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.ohY = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.ohZ = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean eah() {
        return this.ohZ == 1 || this.ohZ == 2 || this.ohZ == 3;
    }

    public String eai() {
        return this.ohX;
    }

    public int cWr() {
        return this.fans;
    }

    public int eaj() {
        return this.ohY;
    }
}
