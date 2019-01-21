package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    private int forumId;
    private String forumName;
    private a hfS = new a();
    private int hhb;
    private int hhc;
    private int hhd;
    private int hhe;
    private int signed;

    public int getForumId() {
        return this.forumId;
    }

    public int bBB() {
        return this.signed;
    }

    public int bBC() {
        return this.hhd;
    }

    public int getCurScore() {
        return this.hhe;
    }

    public a bAX() {
        return this.hfS;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.hfS.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
                this.forumId = jSONObject.optInt("forum_id");
                this.forumName = jSONObject.optString("forum_name");
                this.signed = jSONObject.optInt("signed");
                this.hhb = jSONObject.optInt("is_on");
                this.hhc = jSONObject.optInt("is_filter");
                this.hhd = jSONObject.optInt("sign_day_count");
                this.hhe = jSONObject.optInt("cur_score");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
