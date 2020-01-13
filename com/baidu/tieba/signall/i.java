package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i {
    private int forumId;
    private String forumName;
    private a jWU = new a();
    private int jYe;
    private int jYf;
    private int jYg;
    private int jYh;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cHu() {
        return this.signed;
    }

    public int cHv() {
        return this.jYg;
    }

    public int getCurScore() {
        return this.jYh;
    }

    public a cGQ() {
        return this.jWU;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jWU.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jYe = jSONObject.optInt("is_on");
                this.jYf = jSONObject.optInt("is_filter");
                this.jYg = jSONObject.optInt("sign_day_count");
                this.jYh = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
