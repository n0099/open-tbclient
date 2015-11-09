package com.baidu.tieba.pb.a;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private String aAg;
    private int cgH;
    private String cgI;
    private String cgJ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cgH = jSONObject.optInt("draw_res_type");
                this.aAg = jSONObject.optString("link");
                this.cgI = jSONObject.optString("award_imgsrc");
                this.cgJ = jSONObject.optString("award_des");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }

    public String getLink() {
        return this.aAg;
    }

    public String afc() {
        return this.cgI;
    }

    public String afd() {
        return this.cgJ;
    }
}
