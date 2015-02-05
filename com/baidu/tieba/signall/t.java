package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.home.t bQz = new com.baidu.tieba.home.t();
    private int bRA;
    private int bRB;
    private int bRC;
    private int bRz;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int adX() {
        return this.bRB;
    }

    public int getCurScore() {
        return this.bRC;
    }

    public com.baidu.tieba.home.t adv() {
        return this.bQz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bQz.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.bRz = jSONObject.optInt("is_on");
                this.bRA = jSONObject.optInt("is_filter");
                this.bRB = jSONObject.optInt("sign_day_count");
                this.bRC = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
