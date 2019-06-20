package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a iQg = new a();
    private int iRp;
    private int iRq;
    private int iRr;
    private int iRs;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int ckw() {
        return this.signed;
    }

    public int ckx() {
        return this.iRr;
    }

    public int getCurScore() {
        return this.iRs;
    }

    public a cjS() {
        return this.iQg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iQg.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.iRp = jSONObject.optInt("is_on");
                this.iRq = jSONObject.optInt("is_filter");
                this.iRr = jSONObject.optInt("sign_day_count");
                this.iRs = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
