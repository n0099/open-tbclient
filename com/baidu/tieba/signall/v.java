package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    private a eiO = new a();
    private int ejW;
    private int ejX;
    private int ejY;
    private int ejZ;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int aQv() {
        return this.ejY;
    }

    public int getCurScore() {
        return this.ejZ;
    }

    public a aPS() {
        return this.eiO;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eiO.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.ejW = jSONObject.optInt("is_on");
                this.ejX = jSONObject.optInt("is_filter");
                this.ejY = jSONObject.optInt("sign_day_count");
                this.ejZ = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
