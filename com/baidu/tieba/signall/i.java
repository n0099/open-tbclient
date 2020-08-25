package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class i {
    private int forumId;
    private String forumName;
    private a lVz = new a();
    private int lWM;
    private int lWN;
    private int lWO;
    private int lWP;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dun() {
        return this.signed;
    }

    public int duo() {
        return this.lWO;
    }

    public int getCurScore() {
        return this.lWP;
    }

    public a dtJ() {
        return this.lVz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lVz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.lWM = jSONObject.optInt("is_on");
                this.lWN = jSONObject.optInt("is_filter");
                this.lWO = jSONObject.optInt("sign_day_count");
                this.lWP = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
