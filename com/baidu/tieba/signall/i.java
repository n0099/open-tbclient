package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a jYn = new a();
    private int jZw;
    private int jZx;
    private int jZy;
    private int jZz;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cJd() {
        return this.signed;
    }

    public int cJe() {
        return this.jZy;
    }

    public int getCurScore() {
        return this.jZz;
    }

    public a cIz() {
        return this.jYn;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jYn.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jZw = jSONObject.optInt("is_on");
                this.jZx = jSONObject.optInt("is_filter");
                this.jZy = jSONObject.optInt("sign_day_count");
                this.jZz = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
