package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gLT = new a();
    private int gNd;
    private int gNe;
    private int gNf;
    private int gNg;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int bvy() {
        return this.signed;
    }

    public int bvz() {
        return this.gNf;
    }

    public int getCurScore() {
        return this.gNg;
    }

    public a buU() {
        return this.gLT;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gLT.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gNd = jSONObject.optInt("is_on");
                this.gNe = jSONObject.optInt("is_filter");
                this.gNf = jSONObject.optInt("sign_day_count");
                this.gNg = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
