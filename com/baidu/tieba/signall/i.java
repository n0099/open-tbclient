package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a lbw = new a();
    private int lcI;
    private int lcJ;
    private int lcK;
    private int lcL;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dbd() {
        return this.signed;
    }

    public int dbe() {
        return this.lcK;
    }

    public int getCurScore() {
        return this.lcL;
    }

    public a day() {
        return this.lbw;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lbw.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.lcI = jSONObject.optInt("is_on");
                this.lcJ = jSONObject.optInt("is_filter");
                this.lcK = jSONObject.optInt("sign_day_count");
                this.lcL = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
