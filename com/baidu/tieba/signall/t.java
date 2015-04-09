package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private a cdJ = new a();
    private int ceK;
    private int ceL;
    private int ceM;
    private int ceN;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int ajd() {
        return this.ceM;
    }

    public int getCurScore() {
        return this.ceN;
    }

    public a aiC() {
        return this.cdJ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cdJ.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.ceK = jSONObject.optInt("is_on");
                this.ceL = jSONObject.optInt("is_filter");
                this.ceM = jSONObject.optInt("sign_day_count");
                this.ceN = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
