package com.baidu.tieba.mainentrance.view;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    private static Map<String, String> ljQ;

    public static void NT(String str) {
        try {
            ApplicationInfo.class.getField("primaryCpuAbi").set(((PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0])).applicationInfo, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> dek() {
        if (ljQ == null) {
            try {
                Field declaredField = Class.forName("dalvik.system.VMRuntime").getDeclaredField("ABI_TO_INSTRUCTION_SET_MAP");
                declaredField.setAccessible(true);
                ljQ = (Map) declaredField.get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ljQ;
    }
}
