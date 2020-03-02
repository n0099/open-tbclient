package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a jYb = new a();
    private int jZk;
    private int jZl;
    private int jZm;
    private int jZn;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cJc() {
        return this.signed;
    }

    public int cJd() {
        return this.jZm;
    }

    public int getCurScore() {
        return this.jZn;
    }

    public a cIy() {
        return this.jYb;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jYb.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jZk = jSONObject.optInt("is_on");
                this.jZl = jSONObject.optInt("is_filter");
                this.jZm = jSONObject.optInt("sign_day_count");
                this.jZn = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
