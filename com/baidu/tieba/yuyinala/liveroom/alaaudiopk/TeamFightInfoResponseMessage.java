package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class TeamFightInfoResponseMessage extends JsonHttpResponsedMessage {
    private c osD;

    public c eaM() {
        return this.osD;
    }

    public TeamFightInfoResponseMessage() {
        super(1031087);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031087) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501077, jSONObject.toString()));
            if (this.osD == null) {
                this.osD = new c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.osD.otl = optJSONObject.optInt("next_sync_seconds");
                this.osD.activity_stage = optJSONObject.optInt("activity_stage");
                this.osD.otm = optJSONObject.optInt("stage_end_time");
                this.osD.otn = optJSONObject.optInt("left_seconds");
                this.osD.otq = optJSONObject.optInt("left_milliseconds");
                this.osD.otr = optJSONObject.optInt("need_fix");
                this.osD.ots = optJSONObject.optInt("fix_moment_milli_range");
                this.osD.oto = optJSONObject.optString("pk_winner");
                if (optJSONObject.has("pk_value")) {
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("pk_value"));
                    this.osD.otp = new c.a();
                    this.osD.otp.f5351a = jSONObject2.optString("a");
                    this.osD.otp.f5352b = jSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4046a);
                }
            }
        }
    }
}
