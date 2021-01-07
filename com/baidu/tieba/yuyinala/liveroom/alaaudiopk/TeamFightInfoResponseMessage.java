package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class TeamFightInfoResponseMessage extends JsonHttpResponsedMessage {
    private d omO;

    public d ecj() {
        return this.omO;
    }

    public TeamFightInfoResponseMessage() {
        super(1031087);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031087) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501077, jSONObject.toString()));
            if (this.omO == null) {
                this.omO = new d();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.omO.onx = optJSONObject.optInt("next_sync_seconds");
                this.omO.activity_stage = optJSONObject.optInt("activity_stage");
                this.omO.ony = optJSONObject.optInt("stage_end_time");
                this.omO.onz = optJSONObject.optInt("left_seconds");
                this.omO.onC = optJSONObject.optInt("left_milliseconds");
                this.omO.onD = optJSONObject.optInt("need_fix");
                this.omO.onE = optJSONObject.optInt("fix_moment_milli_range");
                this.omO.onA = optJSONObject.optString("pk_winner");
                if (optJSONObject.has("pk_value")) {
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("pk_value"));
                    this.omO.onB = new d.a();
                    this.omO.onB.f5632a = jSONObject2.optString("a");
                    this.omO.onB.f5633b = jSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4081a);
                }
            }
        }
    }
}
