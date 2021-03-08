package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class DatingStageHttpResponseMessage extends JsonHttpResponsedMessage {
    private a oxg;

    public a ebp() {
        return this.oxg;
    }

    public DatingStageHttpResponseMessage() {
        super(1031081);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031081) {
            if (this.oxg == null) {
                this.oxg = new a();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.oxg.oxf = optJSONObject.optString("activity_stage");
                this.oxg.oxe = optJSONObject.optString("num_fields");
            }
        }
    }
}
