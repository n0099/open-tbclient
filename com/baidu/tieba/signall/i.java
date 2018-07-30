package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gEn = new a();
    private int gFA;
    private int gFx;
    private int gFy;
    private int gFz;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int bsR() {
        return this.signed;
    }

    public int bsS() {
        return this.gFz;
    }

    public int getCurScore() {
        return this.gFA;
    }

    public a bso() {
        return this.gEn;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gEn.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gFx = jSONObject.optInt("is_on");
                this.gFy = jSONObject.optInt("is_filter");
                this.gFz = jSONObject.optInt("sign_day_count");
                this.gFA = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
