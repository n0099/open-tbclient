package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class y {
    public static void ub(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray aKd = ahVar.aKd();
            int length = aKd.length();
            boolean aKe = ahVar.aKe();
            for (int i = 0; i < length; i++) {
                try {
                    if (aKe != g.dwM().tM(aKd.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + aKe + "  content " + ahVar.dxe().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
