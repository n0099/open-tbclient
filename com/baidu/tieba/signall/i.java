package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class i {
    private int forumId;
    private String forumName;
    private a ncy = new a();
    private int ndJ;
    private int ndK;
    private int ndL;
    private int ndM;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dMN() {
        return this.signed;
    }

    public int dMO() {
        return this.ndL;
    }

    public int getCurScore() {
        return this.ndM;
    }

    public a dMk() {
        return this.ncy;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ncy.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.ndJ = jSONObject.optInt("is_on");
                this.ndK = jSONObject.optInt("is_filter");
                this.ndL = jSONObject.optInt("sign_day_count");
                this.ndM = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
