package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class y {
    public static void xJ(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray aXg = ahVar.aXg();
            int length = aXg.length();
            boolean aXh = ahVar.aXh();
            for (int i = 0; i < length; i++) {
                try {
                    if (aXh != g.dPU().xu(aXg.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + aXh + "  content " + ahVar.dQm().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
