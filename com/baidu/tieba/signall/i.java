package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gRE = new a();
    private int gSN;
    private int gSO;
    private int gSP;
    private int gSQ;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int btH() {
        return this.signed;
    }

    public int btI() {
        return this.gSP;
    }

    public int getCurScore() {
        return this.gSQ;
    }

    public a bte() {
        return this.gRE;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gRE.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gSN = jSONObject.optInt("is_on");
                this.gSO = jSONObject.optInt("is_filter");
                this.gSP = jSONObject.optInt("sign_day_count");
                this.gSQ = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
