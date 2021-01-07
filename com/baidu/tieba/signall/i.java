package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    private int forumId;
    private String forumName;
    private a nig = new a();
    private int njr;
    private int njs;
    private int njt;
    private int nju;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dMH() {
        return this.signed;
    }

    public int dMI() {
        return this.njt;
    }

    public int getCurScore() {
        return this.nju;
    }

    public a dMe() {
        return this.nig;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.nig.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.njr = jSONObject.optInt("is_on");
                this.njs = jSONObject.optInt("is_filter");
                this.njt = jSONObject.optInt("sign_day_count");
                this.nju = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
