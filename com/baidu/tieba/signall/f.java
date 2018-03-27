package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public String aKy;
    public String gSa;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gSa = jSONObject.optString("banner_pic");
                this.aKy = jSONObject.optString("banner_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
