package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public String adH;
    public String gEI;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gEI = jSONObject.optString("banner_pic");
                this.adH = jSONObject.optString("banner_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
