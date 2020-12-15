package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class i {
    private int forumId;
    private String forumName;
    private a ncA = new a();
    private int ndL;
    private int ndM;
    private int ndN;
    private int ndO;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dMO() {
        return this.signed;
    }

    public int dMP() {
        return this.ndN;
    }

    public int getCurScore() {
        return this.ndO;
    }

    public a dMl() {
        return this.ncA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ncA.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.ndL = jSONObject.optInt("is_on");
                this.ndM = jSONObject.optInt("is_filter");
                this.ndN = jSONObject.optInt("sign_day_count");
                this.ndO = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
