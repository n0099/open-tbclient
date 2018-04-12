package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gmL = new a();
    private int gnU;
    private int gnV;
    private int gnW;
    private int gnX;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int boQ() {
        return this.signed;
    }

    public int boR() {
        return this.gnW;
    }

    public int getCurScore() {
        return this.gnX;
    }

    public a bon() {
        return this.gmL;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gmL.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gnU = jSONObject.optInt("is_on");
                this.gnV = jSONObject.optInt("is_filter");
                this.gnW = jSONObject.optInt("sign_day_count");
                this.gnX = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
