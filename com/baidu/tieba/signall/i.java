package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a kJc = new a();
    private int kKo;
    private int kKp;
    private int kKq;
    private int kKr;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cUb() {
        return this.signed;
    }

    public int cUc() {
        return this.kKq;
    }

    public int getCurScore() {
        return this.kKr;
    }

    public a cTw() {
        return this.kJc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kJc.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.kKo = jSONObject.optInt("is_on");
                this.kKp = jSONObject.optInt("is_filter");
                this.kKq = jSONObject.optInt("sign_day_count");
                this.kKr = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
