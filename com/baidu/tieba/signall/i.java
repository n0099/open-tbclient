package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    private int forumId;
    private String forumName;
    private a nni = new a();
    private int nou;
    private int nov;
    private int nox;
    private int noy;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dLa() {
        return this.signed;
    }

    public int dLb() {
        return this.nox;
    }

    public int getCurScore() {
        return this.noy;
    }

    public a dKx() {
        return this.nni;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.nni.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.nou = jSONObject.optInt("is_on");
                this.nov = jSONObject.optInt("is_filter");
                this.nox = jSONObject.optInt("sign_day_count");
                this.noy = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
