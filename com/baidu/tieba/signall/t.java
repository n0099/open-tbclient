package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private a cdu = new a();
    private int cev;
    private int cew;
    private int cex;
    private int cey;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int aiO() {
        return this.cex;
    }

    public int getCurScore() {
        return this.cey;
    }

    public a ain() {
        return this.cdu;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cdu.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.cev = jSONObject.optInt("is_on");
                this.cew = jSONObject.optInt("is_filter");
                this.cex = jSONObject.optInt("sign_day_count");
                this.cey = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
