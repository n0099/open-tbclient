package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private com.baidu.tieba.home.t bKA = new com.baidu.tieba.home.t();
    private int bLA;
    private int bLB;
    private int bLC;
    private int bLz;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int adc() {
        return this.bLB;
    }

    public int getCurScore() {
        return this.bLC;
    }

    public com.baidu.tieba.home.t acB() {
        return this.bKA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bKA.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.bLz = jSONObject.optInt("is_on");
                this.bLA = jSONObject.optInt("is_filter");
                this.bLB = jSONObject.optInt("sign_day_count");
                this.bLC = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
