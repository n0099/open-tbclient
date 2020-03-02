package com.baidu.tieba.lego.card.b;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface b {
    a getParallelCharge();

    /* loaded from: classes.dex */
    public static class a {
        public String hXM;
        public String hXN;
        public ArrayList<String> hXO = new ArrayList<>();
        public ArrayList<String> hXP = new ArrayList<>();

        public void parseFromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.hXM = jSONObject.optString("charge_click_url");
                this.hXN = jSONObject.optString("charge_show_url");
                JSONArray optJSONArray = jSONObject.optJSONArray("monitor_show_url");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            this.hXO.add(optString);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("monitor_click_url");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        String optString2 = optJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(optString2)) {
                            this.hXP.add(optString2);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ad_monitor_url");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        JSONObject optJSONObject = optJSONArray3.optJSONObject(i3);
                        if (optJSONObject != null) {
                            String optString3 = optJSONObject.optString("show_url");
                            if (!TextUtils.isEmpty(optString3)) {
                                this.hXO.add(optString3);
                            }
                            String optString4 = optJSONObject.optString("click_url");
                            if (!TextUtils.isEmpty(optString4)) {
                                this.hXP.add(optString4);
                            }
                        }
                    }
                }
            }
        }
    }
}
