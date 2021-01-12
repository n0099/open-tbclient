package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class z {
    public static void ys(String str) {
    }

    public static void d(aj ajVar) {
        if (ajVar != null && !ajVar.isEmpty()) {
            JSONArray bfj = ajVar.bfj();
            int length = bfj.length();
            boolean bfk = ajVar.bfk();
            for (int i = 0; i < length; i++) {
                try {
                    if (bfk != g.eff().yd(bfj.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bfk + "  content " + ajVar.efE().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
