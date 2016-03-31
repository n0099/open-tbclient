package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a efD = new a();
    private int egL;
    private int egM;
    private int egN;
    private int egO;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int aQb() {
        return this.egN;
    }

    public int getCurScore() {
        return this.egO;
    }

    public a aPz() {
        return this.efD;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.efD.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.egL = jSONObject.optInt("is_on");
                this.egM = jSONObject.optInt("is_filter");
                this.egN = jSONObject.optInt("sign_day_count");
                this.egO = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
