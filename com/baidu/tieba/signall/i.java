package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gRF = new a();
    private int gSO;
    private int gSP;
    private int gSQ;
    private int gSR;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int btH() {
        return this.signed;
    }

    public int btI() {
        return this.gSQ;
    }

    public int getCurScore() {
        return this.gSR;
    }

    public a bte() {
        return this.gRF;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gRF.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gSO = jSONObject.optInt("is_on");
                this.gSP = jSONObject.optInt("is_filter");
                this.gSQ = jSONObject.optInt("sign_day_count");
                this.gSR = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
