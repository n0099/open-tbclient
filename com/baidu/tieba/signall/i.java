package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class i {
    private int forumId;
    private String forumName;
    private a lDT = new a();
    private int lFf;
    private int lFg;
    private int lFh;
    private int lFi;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int diS() {
        return this.signed;
    }

    public int diT() {
        return this.lFh;
    }

    public int getCurScore() {
        return this.lFi;
    }

    public a dio() {
        return this.lDT;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lDT.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.lFf = jSONObject.optInt("is_on");
                this.lFg = jSONObject.optInt("is_filter");
                this.lFh = jSONObject.optInt("sign_day_count");
                this.lFi = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
