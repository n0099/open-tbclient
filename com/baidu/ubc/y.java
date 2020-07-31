package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class y {
    public static void ve(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray aNU = ahVar.aNU();
            int length = aNU.length();
            boolean aNV = ahVar.aNV();
            for (int i = 0; i < length; i++) {
                try {
                    if (aNV != g.dzZ().uP(aNU.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + aNV + "  content " + ahVar.dAr().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
