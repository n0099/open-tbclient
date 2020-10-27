package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class y {
    public static void yO(String str) {
    }

    public static void e(ah ahVar) {
        if (ahVar != null && !ahVar.isEmpty()) {
            JSONArray bbH = ahVar.bbH();
            int length = bbH.length();
            boolean bbI = ahVar.bbI();
            for (int i = 0; i < length; i++) {
                try {
                    if (bbI != g.dZx().yz(bbH.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bbI + "  content " + ahVar.dZP().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
