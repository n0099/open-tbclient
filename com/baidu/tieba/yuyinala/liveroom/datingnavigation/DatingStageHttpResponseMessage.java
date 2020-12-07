package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DatingStageHttpResponseMessage extends JsonHttpResponsedMessage {
    private b omr;

    public b edu() {
        return this.omr;
    }

    public DatingStageHttpResponseMessage() {
        super(1031081);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031081) {
            if (this.omr == null) {
                this.omr = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.omr.omq = optJSONObject.optString("activity_stage");
                this.omr.omp = optJSONObject.optString("num_fields");
            }
        }
    }
}
