package com.bytedance.sdk.adnet.d;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class d {
    public static void a(Context context, int i, String str) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            switch (i) {
                case 1:
                    linkedHashMap.put("tnc_config", str);
                    break;
            }
            c.b("MultiProcessFileUtils", "saveData = " + str);
            com.bytedance.sdk.adnet.a.eqR().a(context, linkedHashMap);
        } catch (Exception e) {
        }
    }

    public static String a(Context context, int i) {
        String str = "";
        switch (i) {
            case 1:
                try {
                    str = com.bytedance.sdk.adnet.a.eqR().a(context, "tnc_config", "");
                    break;
                } catch (Exception e) {
                    str = "";
                    break;
                }
        }
        if (str instanceof String) {
            return String.valueOf(str);
        }
        return "";
    }
}
