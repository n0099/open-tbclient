package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class TeamFightInfoResponseMessage extends JsonHttpResponsedMessage {
    private c osd;

    public c eaE() {
        return this.osd;
    }

    public TeamFightInfoResponseMessage() {
        super(1031087);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031087) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501077, jSONObject.toString()));
            if (this.osd == null) {
                this.osd = new c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.osd.osL = optJSONObject.optInt("next_sync_seconds");
                this.osd.activity_stage = optJSONObject.optInt("activity_stage");
                this.osd.osM = optJSONObject.optInt("stage_end_time");
                this.osd.osN = optJSONObject.optInt("left_seconds");
                this.osd.osQ = optJSONObject.optInt("left_milliseconds");
                this.osd.osR = optJSONObject.optInt("need_fix");
                this.osd.osS = optJSONObject.optInt("fix_moment_milli_range");
                this.osd.osO = optJSONObject.optString("pk_winner");
                if (optJSONObject.has("pk_value")) {
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("pk_value"));
                    this.osd.osP = new c.a();
                    this.osd.osP.f5351a = jSONObject2.optString("a");
                    this.osd.osP.f5352b = jSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4046a);
                }
            }
        }
    }
}
