package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.home.t bKl = new com.baidu.tieba.home.t();
    private int bLk;
    private int bLl;
    private int bLm;
    private int bLn;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int acZ() {
        return this.bLm;
    }

    public int getCurScore() {
        return this.bLn;
    }

    public com.baidu.tieba.home.t acy() {
        return this.bKl;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bKl.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.bLk = jSONObject.optInt("is_on");
                this.bLl = jSONObject.optInt("is_filter");
                this.bLm = jSONObject.optInt("sign_day_count");
                this.bLn = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
