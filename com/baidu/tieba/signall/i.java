package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {
    private int forumId;
    private String forumName;
    private a ndA = new a();
    private int neM;
    private int neN;
    private int neO;
    private int neP;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dIP() {
        return this.signed;
    }

    public int dIQ() {
        return this.neO;
    }

    public int getCurScore() {
        return this.neP;
    }

    public a dIm() {
        return this.ndA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ndA.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.neM = jSONObject.optInt("is_on");
                this.neN = jSONObject.optInt("is_filter");
                this.neO = jSONObject.optInt("sign_day_count");
                this.neP = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
