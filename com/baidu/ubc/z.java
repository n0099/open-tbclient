package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class z {
    public static void yL(String str) {
    }

    public static void d(aj ajVar) {
        if (ajVar != null && !ajVar.isEmpty()) {
            JSONArray bfw = ajVar.bfw();
            int length = bfw.length();
            boolean bfx = ajVar.bfx();
            for (int i = 0; i < length; i++) {
                try {
                    if (bfx != g.ehF().yw(bfw.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bfx + "  content " + ajVar.eie().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
