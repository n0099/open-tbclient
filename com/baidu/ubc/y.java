package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class y {
    public static void xp(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray aWu = ahVar.aWu();
            int length = aWu.length();
            boolean aWv = ahVar.aWv();
            for (int i = 0; i < length; i++) {
                try {
                    if (aWv != g.dLN().xa(aWu.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + aWv + "  content " + ahVar.dMf().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
