package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DatingStageHttpResponseMessage extends JsonHttpResponsedMessage {
    private a ovb;

    public a ebh() {
        return this.ovb;
    }

    public DatingStageHttpResponseMessage() {
        super(1031081);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031081) {
            if (this.ovb == null) {
                this.ovb = new a();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.ovb.ova = optJSONObject.optString("activity_stage");
                this.ovb.ouZ = optJSONObject.optString("num_fields");
            }
        }
    }
}
