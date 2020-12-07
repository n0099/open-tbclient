package com.baidu.ubc;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class z {
    public static void zE(String str) {
    }

    public static void d(aj ajVar) {
        if (ajVar != null && !ajVar.isEmpty()) {
            JSONArray bgF = ajVar.bgF();
            int length = bgF.length();
            boolean bgG = ajVar.bgG();
            for (int i = 0; i < length; i++) {
                try {
                    if (bgG != g.eiL().zp(bgF.getJSONObject(i).getString("id"))) {
                        Log.w("UBCDebug", " data is " + bgG + "  content " + ajVar.ejk().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
