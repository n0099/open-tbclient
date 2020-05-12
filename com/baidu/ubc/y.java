package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class y {
    public static void so(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray aEp = ahVar.aEp();
            int length = aEp.length();
            boolean aEq = ahVar.aEq();
            for (int i = 0; i < length; i++) {
                try {
                    if (aEq != g.dkz().sb(aEp.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + aEq + "  content " + ahVar.dkR().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
