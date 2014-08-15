package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bd {
    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("config");
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("switch")) != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("name");
                            Integer valueOf = Integer.valueOf(jSONObject2.optInt("type", 0));
                            if ("switch_login_passv6".equals(optString)) {
                                com.baidu.adp.lib.a.f.a().a(optString, valueOf.intValue());
                                LoginActivity.a();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
