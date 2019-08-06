package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a iXB = new a();
    private int iYK;
    private int iYL;
    private int iYM;
    private int iYN;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cnF() {
        return this.signed;
    }

    public int cnG() {
        return this.iYM;
    }

    public int getCurScore() {
        return this.iYN;
    }

    public a cnb() {
        return this.iXB;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iXB.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.iYK = jSONObject.optInt("is_on");
                this.iYL = jSONObject.optInt("is_filter");
                this.iYM = jSONObject.optInt("sign_day_count");
                this.iYN = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
