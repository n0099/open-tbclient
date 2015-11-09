package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private a cRq = new a();
    private int cSr;
    private int cSs;
    private int cSt;
    private int cSu;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int auu() {
        return this.cSt;
    }

    public int getCurScore() {
        return this.cSu;
    }

    public a atT() {
        return this.cRq;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cRq.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.cSr = jSONObject.optInt("is_on");
                this.cSs = jSONObject.optInt("is_filter");
                this.cSt = jSONObject.optInt("sign_day_count");
                this.cSu = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
