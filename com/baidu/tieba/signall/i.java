package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gmI = new a();
    private int gnR;
    private int gnS;
    private int gnT;
    private int gnU;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int boQ() {
        return this.signed;
    }

    public int boR() {
        return this.gnT;
    }

    public int getCurScore() {
        return this.gnU;
    }

    public a bon() {
        return this.gmI;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gmI.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gnR = jSONObject.optInt("is_on");
                this.gnS = jSONObject.optInt("is_filter");
                this.gnT = jSONObject.optInt("sign_day_count");
                this.gnU = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
