package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private a cAc = new a();
    private int cBd;
    private int cBe;
    private int cBf;
    private int cBg;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int anp() {
        return this.cBf;
    }

    public int getCurScore() {
        return this.cBg;
    }

    public a amO() {
        return this.cAc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cAc.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.cBd = jSONObject.optInt("is_on");
                this.cBe = jSONObject.optInt("is_filter");
                this.cBf = jSONObject.optInt("sign_day_count");
                this.cBg = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
