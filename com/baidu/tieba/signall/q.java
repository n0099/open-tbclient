package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private a cIA = new a();
    private int cJB;
    private int cJC;
    private int cJD;
    private int cJE;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int ary() {
        return this.cJD;
    }

    public int getCurScore() {
        return this.cJE;
    }

    public a aqX() {
        return this.cIA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cIA.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.cJB = jSONObject.optInt("is_on");
                this.cJC = jSONObject.optInt("is_filter");
                this.cJD = jSONObject.optInt("sign_day_count");
                this.cJE = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
