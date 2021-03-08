package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TeamFightInfoResponseMessage extends JsonHttpResponsedMessage {
    private c ouJ;

    public c eaU() {
        return this.ouJ;
    }

    public TeamFightInfoResponseMessage() {
        super(1031087);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031087) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501077, jSONObject.toString()));
            if (this.ouJ == null) {
                this.ouJ = new c();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.ouJ.ovr = optJSONObject.optInt("next_sync_seconds");
                this.ouJ.activity_stage = optJSONObject.optInt("activity_stage");
                this.ouJ.ovs = optJSONObject.optInt("stage_end_time");
                this.ouJ.ovt = optJSONObject.optInt("left_seconds");
                this.ouJ.ovw = optJSONObject.optInt("left_milliseconds");
                this.ouJ.ovx = optJSONObject.optInt("need_fix");
                this.ouJ.ovy = optJSONObject.optInt("fix_moment_milli_range");
                this.ouJ.ovu = optJSONObject.optString("pk_winner");
                if (optJSONObject.has("pk_value")) {
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("pk_value"));
                    this.ouJ.ovv = new c.a();
                    this.ouJ.ovv.f3603a = jSONObject2.optString("a");
                    this.ouJ.ovv.b = jSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f2804a);
                }
            }
        }
    }
}
