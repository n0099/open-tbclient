package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class y {
    public static void yv(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray aZO = ahVar.aZO();
            int length = aZO.length();
            boolean aZP = ahVar.aZP();
            for (int i = 0; i < length; i++) {
                try {
                    if (aZP != g.dTF().yg(aZO.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + aZP + "  content " + ahVar.dTX().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
