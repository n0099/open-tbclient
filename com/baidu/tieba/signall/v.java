package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a dwZ = new a();
    private int dyi;
    private int dyj;
    private int dyk;
    private int dyl;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int aCe() {
        return this.dyk;
    }

    public int getCurScore() {
        return this.dyl;
    }

    public a aBC() {
        return this.dwZ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dwZ.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.dyi = jSONObject.optInt("is_on");
                this.dyj = jSONObject.optInt("is_filter");
                this.dyk = jSONObject.optInt("sign_day_count");
                this.dyl = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
