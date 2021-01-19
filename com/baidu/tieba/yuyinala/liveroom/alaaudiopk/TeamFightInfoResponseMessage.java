package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.d;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TeamFightInfoResponseMessage extends JsonHttpResponsedMessage {
    private d oik;

    public d dYr() {
        return this.oik;
    }

    public TeamFightInfoResponseMessage() {
        super(1031087);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031087) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501077, jSONObject.toString()));
            if (this.oik == null) {
                this.oik = new d();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.oik.oiS = optJSONObject.optInt("next_sync_seconds");
                this.oik.activity_stage = optJSONObject.optInt("activity_stage");
                this.oik.oiT = optJSONObject.optInt("stage_end_time");
                this.oik.oiU = optJSONObject.optInt("left_seconds");
                this.oik.oiX = optJSONObject.optInt("left_milliseconds");
                this.oik.oiY = optJSONObject.optInt("need_fix");
                this.oik.oiZ = optJSONObject.optInt("fix_moment_milli_range");
                this.oik.oiV = optJSONObject.optString("pk_winner");
                if (optJSONObject.has("pk_value")) {
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("pk_value"));
                    this.oik.oiW = new d.a();
                    this.oik.oiW.f5349a = jSONObject2.optString("a");
                    this.oik.oiW.f5350b = jSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4043a);
                }
            }
        }
    }
}
