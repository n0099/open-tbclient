package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {
    private int forumId;
    private String forumName;
    private a iYW = new a();
    private int jag;
    private int jah;
    private int jai;
    private int jaj;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cmg() {
        return this.signed;
    }

    public int cmh() {
        return this.jai;
    }

    public int getCurScore() {
        return this.jaj;
    }

    public a clC() {
        return this.iYW;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.iYW.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jag = jSONObject.optInt("is_on");
                this.jah = jSONObject.optInt("is_filter");
                this.jai = jSONObject.optInt("sign_day_count");
                this.jaj = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
