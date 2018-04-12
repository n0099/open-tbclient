package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public String VS;
    public String gng;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.gng = jSONObject.optString("banner_pic");
                this.VS = jSONObject.optString("banner_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
