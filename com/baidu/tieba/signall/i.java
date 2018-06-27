package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gDf = new a();
    private int gEo;
    private int gEp;
    private int gEq;
    private int gEr;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int buo() {
        return this.signed;
    }

    public int bup() {
        return this.gEq;
    }

    public int getCurScore() {
        return this.gEr;
    }

    public a btL() {
        return this.gDf;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gDf.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gEo = jSONObject.optInt("is_on");
                this.gEp = jSONObject.optInt("is_filter");
                this.gEq = jSONObject.optInt("sign_day_count");
                this.gEr = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
