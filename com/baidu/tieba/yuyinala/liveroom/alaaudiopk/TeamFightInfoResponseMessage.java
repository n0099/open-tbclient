package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TeamFightInfoResponseMessage extends JsonHttpResponsedMessage {
    private d oij;

    public d dYr() {
        return this.oij;
    }

    public TeamFightInfoResponseMessage() {
        super(1031087);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031087) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501077, jSONObject.toString()));
            if (this.oij == null) {
                this.oij = new d();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.oij.oiR = optJSONObject.optInt("next_sync_seconds");
                this.oij.activity_stage = optJSONObject.optInt("activity_stage");
                this.oij.oiS = optJSONObject.optInt("stage_end_time");
                this.oij.oiT = optJSONObject.optInt("left_seconds");
                this.oij.oiW = optJSONObject.optInt("left_milliseconds");
                this.oij.oiX = optJSONObject.optInt("need_fix");
                this.oij.oiY = optJSONObject.optInt("fix_moment_milli_range");
                this.oij.oiU = optJSONObject.optString("pk_winner");
                if (optJSONObject.has("pk_value")) {
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("pk_value"));
                    this.oij.oiV = new d.a();
                    this.oij.oiV.f5349a = jSONObject2.optString("a");
                    this.oij.oiV.f5350b = jSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4043a);
                }
            }
        }
    }
}
