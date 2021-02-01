package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DatingStageHttpResponseMessage extends JsonHttpResponsedMessage {
    private a ouB;

    public a eaZ() {
        return this.ouB;
    }

    public DatingStageHttpResponseMessage() {
        super(1031081);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031081) {
            if (this.ouB == null) {
                this.ouB = new a();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.ouB.ouA = optJSONObject.optString("activity_stage");
                this.ouB.ouz = optJSONObject.optString("num_fields");
            }
        }
    }
}
