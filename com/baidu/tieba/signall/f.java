package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public String aKI;
    public String gRZ;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gRZ = jSONObject.optString("banner_pic");
                this.aKI = jSONObject.optString("banner_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
