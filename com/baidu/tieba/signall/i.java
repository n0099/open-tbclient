package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gEq = new a();
    private int gFA;
    private int gFB;
    private int gFC;
    private int gFD;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int bsS() {
        return this.signed;
    }

    public int bsT() {
        return this.gFC;
    }

    public int getCurScore() {
        return this.gFD;
    }

    public a bsp() {
        return this.gEq;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gEq.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gFA = jSONObject.optInt("is_on");
                this.gFB = jSONObject.optInt("is_filter");
                this.gFC = jSONObject.optInt("sign_day_count");
                this.gFD = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
