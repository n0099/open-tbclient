package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class k {
    public String link;
    public String nep;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.nep = jSONObject.optString("banner");
                this.link = jSONObject.optString("link");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
