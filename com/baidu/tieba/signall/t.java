package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private a chO = new a();
    private int ciQ;
    private int ciR;
    private int ciS;
    private int ciT;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int akO() {
        return this.ciS;
    }

    public int getCurScore() {
        return this.ciT;
    }

    public a akn() {
        return this.chO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.chO.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.ciQ = jSONObject.optInt("is_on");
                this.ciR = jSONObject.optInt("is_filter");
                this.ciS = jSONObject.optInt("sign_day_count");
                this.ciT = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
