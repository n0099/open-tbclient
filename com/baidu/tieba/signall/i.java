package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a ixn = new a();
    private int iyw;
    private int iyx;
    private int iyy;
    private int iyz;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cco() {
        return this.signed;
    }

    public int ccp() {
        return this.iyy;
    }

    public int getCurScore() {
        return this.iyz;
    }

    public a cbK() {
        return this.ixn;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ixn.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.iyw = jSONObject.optInt("is_on");
                this.iyx = jSONObject.optInt("is_filter");
                this.iyy = jSONObject.optInt("sign_day_count");
                this.iyz = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
