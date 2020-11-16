package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class i {
    private int forumId;
    private String forumName;
    private a mOs = new a();
    private int mPF;
    private int mPG;
    private int mPH;
    private int mPI;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dHx() {
        return this.signed;
    }

    public int dHy() {
        return this.mPH;
    }

    public int getCurScore() {
        return this.mPI;
    }

    public a dGT() {
        return this.mOs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mOs.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.mPF = jSONObject.optInt("is_on");
                this.mPG = jSONObject.optInt("is_filter");
                this.mPH = jSONObject.optInt("sign_day_count");
                this.mPI = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
