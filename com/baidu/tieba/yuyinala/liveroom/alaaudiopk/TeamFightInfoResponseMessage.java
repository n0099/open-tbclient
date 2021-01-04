package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class TeamFightInfoResponseMessage extends JsonHttpResponsedMessage {
    private d omP;

    public d eci() {
        return this.omP;
    }

    public TeamFightInfoResponseMessage() {
        super(1031087);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031087) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501077, jSONObject.toString()));
            if (this.omP == null) {
                this.omP = new d();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.omP.ony = optJSONObject.optInt("next_sync_seconds");
                this.omP.activity_stage = optJSONObject.optInt("activity_stage");
                this.omP.onz = optJSONObject.optInt("stage_end_time");
                this.omP.onA = optJSONObject.optInt("left_seconds");
                this.omP.onD = optJSONObject.optInt("left_milliseconds");
                this.omP.onE = optJSONObject.optInt("need_fix");
                this.omP.onF = optJSONObject.optInt("fix_moment_milli_range");
                this.omP.onB = optJSONObject.optString("pk_winner");
                if (optJSONObject.has("pk_value")) {
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("pk_value"));
                    this.omP.onC = new d.a();
                    this.omP.onC.f5631a = jSONObject2.optString("a");
                    this.omP.onC.f5632b = jSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4080a);
                }
            }
        }
    }
}
