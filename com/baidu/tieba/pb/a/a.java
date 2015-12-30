package com.baidu.tieba.pb.a;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private int cCK;
    private String cCL;
    private String cCM;
    private String mLink;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cCK = jSONObject.optInt("draw_res_type");
                this.mLink = jSONObject.optString("link");
                this.cCL = jSONObject.optString("award_imgsrc");
                this.cCM = jSONObject.optString("award_des");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public String getLink() {
        return this.mLink;
    }

    public String akC() {
        return this.cCL;
    }

    public String akD() {
        return this.cCM;
    }
}
