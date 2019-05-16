package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a iQa = new a();
    private int iRj;
    private int iRk;
    private int iRl;
    private int iRm;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int ckt() {
        return this.signed;
    }

    public int cku() {
        return this.iRl;
    }

    public int getCurScore() {
        return this.iRm;
    }

    public a cjP() {
        return this.iQa;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iQa.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.iRj = jSONObject.optInt("is_on");
                this.iRk = jSONObject.optInt("is_filter");
                this.iRl = jSONObject.optInt("sign_day_count");
                this.iRm = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
