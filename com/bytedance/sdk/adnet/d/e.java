package com.bytedance.sdk.adnet.d;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class e {
    public static void a(Context context, int i, String str) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            switch (i) {
                case 1:
                    linkedHashMap.put("tnc_config", str);
                    break;
            }
            d.b("MultiProcessFileUtils", "saveData = " + str);
            com.bytedance.sdk.adnet.a.eqK().a(context, linkedHashMap);
        } catch (Exception e) {
        }
    }

    public static String a(Context context, int i) {
        String str = "";
        switch (i) {
            case 1:
                try {
                    str = com.bytedance.sdk.adnet.a.eqK().a(context, "tnc_config", "");
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
