package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private a cPv = new a();
    private int cQw;
    private int cQx;
    private int cQy;
    private int cQz;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int atM() {
        return this.cQy;
    }

    public int getCurScore() {
        return this.cQz;
    }

    public a atl() {
        return this.cPv;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cPv.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.cQw = jSONObject.optInt("is_on");
                this.cQx = jSONObject.optInt("is_filter");
                this.cQy = jSONObject.optInt("sign_day_count");
                this.cQz = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
