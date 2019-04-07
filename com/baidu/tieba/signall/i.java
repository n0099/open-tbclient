package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a ixm = new a();
    private int iyv;
    private int iyw;
    private int iyx;
    private int iyy;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cco() {
        return this.signed;
    }

    public int ccp() {
        return this.iyx;
    }

    public int getCurScore() {
        return this.iyy;
    }

    public a cbK() {
        return this.ixm;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ixm.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.iyv = jSONObject.optInt("is_on");
                this.iyw = jSONObject.optInt("is_filter");
                this.iyx = jSONObject.optInt("sign_day_count");
                this.iyy = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
