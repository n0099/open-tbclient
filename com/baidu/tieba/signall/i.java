package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class i {
    private int forumId;
    private String forumName;
    private a mNz = new a();
    private int mOK;
    private int mOL;
    private int mOM;
    private int mON;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dHG() {
        return this.signed;
    }

    public int dHH() {
        return this.mOM;
    }

    public int getCurScore() {
        return this.mON;
    }

    public a dHc() {
        return this.mNz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mNz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.mOK = jSONObject.optInt("is_on");
                this.mOL = jSONObject.optInt("is_filter");
                this.mOM = jSONObject.optInt("sign_day_count");
                this.mON = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
