package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gUR = new a();
    private int gWa;
    private int gWb;
    private int gWc;
    private int gWd;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int byj() {
        return this.signed;
    }

    public int byk() {
        return this.gWc;
    }

    public int getCurScore() {
        return this.gWd;
    }

    public a bxF() {
        return this.gUR;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gUR.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gWa = jSONObject.optInt("is_on");
                this.gWb = jSONObject.optInt("is_filter");
                this.gWc = jSONObject.optInt("sign_day_count");
                this.gWd = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
