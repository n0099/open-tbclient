package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private a chN = new a();
    private int ciP;
    private int ciQ;
    private int ciR;
    private int ciS;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int akN() {
        return this.ciR;
    }

    public int getCurScore() {
        return this.ciS;
    }

    public a akm() {
        return this.chN;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.chN.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.ciP = jSONObject.optInt("is_on");
                this.ciQ = jSONObject.optInt("is_filter");
                this.ciR = jSONObject.optInt("sign_day_count");
                this.ciS = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
