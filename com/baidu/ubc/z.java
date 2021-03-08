package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class z {
    public static void yS(String str) {
    }

    public static void d(aj ajVar) {
        if (ajVar != null && !ajVar.isEmpty()) {
            JSONArray bfy = ajVar.bfy();
            int length = bfy.length();
            boolean bfz = ajVar.bfz();
            for (int i = 0; i < length; i++) {
                try {
                    if (bfz != g.ehN().yD(bfy.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bfz + "  content " + ajVar.eim().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
