package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.home.t bQA = new com.baidu.tieba.home.t();
    private int bRA;
    private int bRB;
    private int bRC;
    private int bRD;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int aec() {
        return this.bRC;
    }

    public int getCurScore() {
        return this.bRD;
    }

    public com.baidu.tieba.home.t adA() {
        return this.bQA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bQA.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.bRA = jSONObject.optInt("is_on");
                this.bRB = jSONObject.optInt("is_filter");
                this.bRC = jSONObject.optInt("sign_day_count");
                this.bRD = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
