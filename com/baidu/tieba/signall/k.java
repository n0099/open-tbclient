package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class k {
    public String link;
    public String mQl;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mQl = jSONObject.optString("banner");
                this.link = jSONObject.optString("link");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
