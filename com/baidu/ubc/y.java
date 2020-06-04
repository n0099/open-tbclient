package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class y {
    public static void tT(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray aIX = ahVar.aIX();
            int length = aIX.length();
            boolean aIY = ahVar.aIY();
            for (int i = 0; i < length; i++) {
                try {
                    if (aIY != g.dsd().tE(aIX.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + aIY + "  content " + ahVar.dsv().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
