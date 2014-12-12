package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.home.u bOQ = new com.baidu.tieba.home.u();
    private int bPQ;
    private int bPR;
    private int bPS;
    private int bPT;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int ady() {
        return this.bPS;
    }

    public int getCurScore() {
        return this.bPT;
    }

    public com.baidu.tieba.home.u acW() {
        return this.bOQ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bOQ.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.bPQ = jSONObject.optInt("is_on");
                this.bPR = jSONObject.optInt("is_filter");
                this.bPS = jSONObject.optInt("sign_day_count");
                this.bPT = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
