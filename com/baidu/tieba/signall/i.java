package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private int forumId;
    private String forumName;
    private a kJg = new a();
    private int kKs;
    private int kKt;
    private int kKu;
    private int kKv;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int cTY() {
        return this.signed;
    }

    public int cTZ() {
        return this.kKu;
    }

    public int getCurScore() {
        return this.kKv;
    }

    public a cTt() {
        return this.kJg;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.kJg.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.kKs = jSONObject.optInt("is_on");
                this.kKt = jSONObject.optInt("is_filter");
                this.kKu = jSONObject.optInt("sign_day_count");
                this.kKv = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
