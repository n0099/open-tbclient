package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private a cPU = new a();
    private int cQV;
    private int cQW;
    private int cQX;
    private int cQY;
    private int forumId;
    private String forumName;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int getSigned() {
        return this.signed;
    }

    public int atS() {
        return this.cQX;
    }

    public int getCurScore() {
        return this.cQY;
    }

    public a atr() {
        return this.cPU;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cPU.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.cQV = jSONObject.optInt("is_on");
                this.cQW = jSONObject.optInt("is_filter");
                this.cQX = jSONObject.optInt("sign_day_count");
                this.cQY = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
