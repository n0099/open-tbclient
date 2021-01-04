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
            JSONArray bjc = ajVar.bjc();
            int length = bjc.length();
            boolean bjd = ajVar.bjd();
            for (int i = 0; i < length; i++) {
                try {
                    if (bjd != g.eiW().zo(bjc.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bjd + "  content " + ajVar.ejv().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
