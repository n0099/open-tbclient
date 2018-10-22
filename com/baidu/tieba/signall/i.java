package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a gTr = new a();
    private int gUB;
    private int gUC;
    private int gUD;
    private int gUE;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int byN() {
        return this.signed;
    }

    public int byO() {
        return this.gUD;
    }

    public int getCurScore() {
        return this.gUE;
    }

    public a byj() {
        return this.gTr;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gTr.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.gUB = jSONObject.optInt("is_on");
                this.gUC = jSONObject.optInt("is_filter");
                this.gUD = jSONObject.optInt("sign_day_count");
                this.gUE = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
