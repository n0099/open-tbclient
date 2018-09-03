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
        public String ePA;
        public ArrayList<String> ePB = new ArrayList<>();
        public ArrayList<String> ePC = new ArrayList<>();
        public String ePz;

        public void parseFromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.ePz = jSONObject.optString("charge_click_url");
                this.ePA = jSONObject.optString("charge_show_url");
                JSONArray optJSONArray = jSONObject.optJSONArray("monitor_show_url");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            this.ePB.add(optString);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("monitor_click_url");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        String optString2 = optJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(optString2)) {
                            this.ePC.add(optString2);
                        }
                    }
                }
            }
        }
    }
}
