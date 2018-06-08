package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private int gAv;
    private int gAw;
    private int gAx;
    private int gAy;
    private a gzm = new a();
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int btO() {
        return this.signed;
    }

    public int btP() {
        return this.gAx;
    }

    public int getCurScore() {
        return this.gAy;
    }

    public a btl() {
        return this.gzm;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gzm.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gAv = jSONObject.optInt("is_on");
                this.gAw = jSONObject.optInt("is_filter");
                this.gAx = jSONObject.optInt("sign_day_count");
                this.gAy = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
