package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaEndConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int fans;
    private String oJx;
    private int oJy;
    private int oJz;

    public AlaEndConnectionWheatHttpResponseMessage() {
        super(1031011);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031011 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oJx = optJSONObject.optString("minute");
            this.fans = optJSONObject.optInt("fans");
            this.oJy = optJSONObject.optInt(SdkStaticKeys.RANK_TYPE_CHARM);
            this.oJz = optJSONObject.optInt(SubPbActivityConfig.KEY_USER_IDENTITY);
        }
    }

    public boolean eeB() {
        return this.oJz == 1 || this.oJz == 2 || this.oJz == 3;
    }

    public String eeC() {
        return this.oJx;
    }

    public int cZv() {
        return this.fans;
    }

    public int eeD() {
        return this.oJy;
    }
}
