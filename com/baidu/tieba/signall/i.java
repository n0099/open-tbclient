package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gRp = new a();
    private int gSA;
    private int gSB;
    private int gSy;
    private int gSz;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int btG() {
        return this.signed;
    }

    public int btH() {
        return this.gSA;
    }

    public int getCurScore() {
        return this.gSB;
    }

    public a btd() {
        return this.gRp;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gRp.parserJson(jSONObject.optJSONObject("error"));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gSy = jSONObject.optInt("is_on");
                this.gSz = jSONObject.optInt("is_filter");
                this.gSA = jSONObject.optInt("sign_day_count");
                this.gSB = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
