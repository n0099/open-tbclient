package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    private int forumId;
    private String forumName;
    private a jTs = new a();
    private int jUC;
    private int jUD;
    private int jUE;
    private int jUF;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cGq() {
        return this.signed;
    }

    public int cGr() {
        return this.jUE;
    }

    public int getCurScore() {
        return this.jUF;
    }

    public a cFM() {
        return this.jTs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.jTs.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.jUC = jSONObject.optInt("is_on");
                this.jUD = jSONObject.optInt("is_filter");
                this.jUE = jSONObject.optInt("sign_day_count");
                this.jUF = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
