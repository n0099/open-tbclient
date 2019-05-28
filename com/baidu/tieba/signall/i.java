package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a iQc = new a();
    private int iRl;
    private int iRm;
    private int iRn;
    private int iRo;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int ckv() {
        return this.signed;
    }

    public int ckw() {
        return this.iRn;
    }

    public int getCurScore() {
        return this.iRo;
    }

    public a cjR() {
        return this.iQc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iQc.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.iRl = jSONObject.optInt("is_on");
                this.iRm = jSONObject.optInt("is_filter");
                this.iRn = jSONObject.optInt("sign_day_count");
                this.iRo = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
