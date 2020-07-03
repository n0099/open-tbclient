package com.baidu.tieba.mainentrance.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static Map<String, String> jyU;

    public static void Im(String str) {
        try {
            ApplicationInfo.class.getField("primaryCpuAbi").set(((PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0])).applicationInfo, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> czS() {
        if (jyU == null) {
            try {
                Field declaredField = Class.forName("dalvik.system.VMRuntime").getDeclaredField("ABI_TO_INSTRUCTION_SET_MAP");
                declaredField.setAccessible(true);
                jyU = (Map) declaredField.get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jyU;
    }
}
