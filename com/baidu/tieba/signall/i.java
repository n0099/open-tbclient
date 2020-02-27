package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a jXZ = new a();
    private int jZi;
    private int jZj;
    private int jZk;
    private int jZl;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cJa() {
        return this.signed;
    }

    public int cJb() {
        return this.jZk;
    }

    public int getCurScore() {
        return this.jZl;
    }

    public a cIw() {
        return this.jXZ;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jXZ.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jZi = jSONObject.optInt("is_on");
                this.jZj = jSONObject.optInt("is_filter");
                this.jZk = jSONObject.optInt("sign_day_count");
                this.jZl = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
