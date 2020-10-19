package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class i {
    private int forumId;
    private String forumName;
    private a muT = new a();
    private int mwf;
    private int mwg;
    private int mwh;
    private int mwi;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int dBW() {
        return this.signed;
    }

    public int dBX() {
        return this.mwh;
    }

    public int getCurScore() {
        return this.mwi;
    }

    public a dBs() {
        return this.muT;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.muT.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.mwf = jSONObject.optInt("is_on");
                this.mwg = jSONObject.optInt("is_filter");
                this.mwh = jSONObject.optInt("sign_day_count");
                this.mwi = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
