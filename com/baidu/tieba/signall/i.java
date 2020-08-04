package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class i {
    private int forumId;
    private String forumName;
    private a lDV = new a();
    private int lFh;
    private int lFi;
    private int lFj;
    private int lFk;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int diS() {
        return this.signed;
    }

    public int diT() {
        return this.lFj;
    }

    public int getCurScore() {
        return this.lFk;
    }

    public a dio() {
        return this.lDV;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.lDV.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.lFh = jSONObject.optInt("is_on");
                this.lFi = jSONObject.optInt("is_filter");
                this.lFj = jSONObject.optInt("sign_day_count");
                this.lFk = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
