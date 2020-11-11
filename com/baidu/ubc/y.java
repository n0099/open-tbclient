package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class y {
    public static void zc(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray beh = ahVar.beh();
            int length = beh.length();
            boolean bei = ahVar.bei();
            for (int i = 0; i < length; i++) {
                try {
                    if (bei != g.edf().yN(beh.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bei + "  content " + ahVar.edx().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
