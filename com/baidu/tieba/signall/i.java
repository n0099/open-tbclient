package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a lcF = new a();
    private int ldR;
    private int ldS;
    private int ldT;
    private int ldU;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dbt() {
        return this.signed;
    }

    public int dbu() {
        return this.ldT;
    }

    public int getCurScore() {
        return this.ldU;
    }

    public a daO() {
        return this.lcF;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lcF.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.ldR = jSONObject.optInt("is_on");
                this.ldS = jSONObject.optInt("is_filter");
                this.ldT = jSONObject.optInt("sign_day_count");
                this.ldU = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
