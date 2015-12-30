package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public String UQ;
    public String dxv;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dxv = jSONObject.optString("banner_pic");
                this.UQ = jSONObject.optString("banner_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
