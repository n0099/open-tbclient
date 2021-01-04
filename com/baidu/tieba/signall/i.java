package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    private int forumId;
    private String forumName;
    private a nih = new a();
    private int njs;
    private int njt;
    private int nju;
    private int njv;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dMG() {
        return this.signed;
    }

    public int dMH() {
        return this.nju;
    }

    public int getCurScore() {
        return this.njv;
    }

    public a dMd() {
        return this.nih;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.nih.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.njs = jSONObject.optInt("is_on");
                this.njt = jSONObject.optInt("is_filter");
                this.nju = jSONObject.optInt("sign_day_count");
                this.njv = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
