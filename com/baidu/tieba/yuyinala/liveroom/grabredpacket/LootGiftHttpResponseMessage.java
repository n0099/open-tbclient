package com.baidu.tieba.yuyinala.liveroom.grabredpacket;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LootGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    public int id;
    public String image;
    public String name;
    public String text;
    public String tip;

    public LootGiftHttpResponseMessage() {
        super(1031083);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031083 && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONObject2 = optJSONObject.optJSONObject(UbcStatConstant.DebugContentValue.GIFT)) != null) {
            this.image = optJSONObject2.optString("image");
            this.text = optJSONObject2.optString("text");
            this.tip = optJSONObject2.optString(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
            this.id = optJSONObject2.optInt("id");
            this.name = optJSONObject2.optString("name");
        }
    }
}
