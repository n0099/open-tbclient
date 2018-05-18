package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gnO = new a();
    private int goX;
    private int goY;
    private int goZ;
    private int gpa;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int boO() {
        return this.signed;
    }

    public int boP() {
        return this.goZ;
    }

    public int getCurScore() {
        return this.gpa;
    }

    public a bol() {
        return this.gnO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gnO.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.goX = jSONObject.optInt("is_on");
                this.goY = jSONObject.optInt("is_filter");
                this.goZ = jSONObject.optInt("sign_day_count");
                this.gpa = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
