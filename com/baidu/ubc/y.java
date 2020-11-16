package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class y {
    public static void yX(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray bdA = ahVar.bdA();
            int length = bdA.length();
            boolean bdB = ahVar.bdB();
            for (int i = 0; i < length; i++) {
                try {
                    if (bdB != g.ede().yI(bdA.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bdB + "  content " + ahVar.edw().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
