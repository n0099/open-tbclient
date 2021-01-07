package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class z {
    public static void zD(String str) {
    }

    public static void d(aj ajVar) {
        if (ajVar != null && !ajVar.isEmpty()) {
            JSONArray bjd = ajVar.bjd();
            int length = bjd.length();
            boolean bje = ajVar.bje();
            for (int i = 0; i < length; i++) {
                try {
                    if (bje != g.eiX().zo(bjd.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bje + "  content " + ajVar.ejw().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
