package com.baidu.ubs.analytics.d;

import android.os.Environment;
/* loaded from: classes3.dex */
public final class a {
    private static final String jxg = Environment.getExternalStorageDirectory().getPath();
    static final String jxh = jxg + "/baidu/ab/crash/";
    static final String jxi = jxg + "/baidu/ab/sdklog/";
    public static final String jxj = jxg + "/baidu/ab/sdkupdata/" + csx() + "/";
    private static int aU = EnumC0327a.aV;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class EnumC0327a {
        public static final int aV = 1;
        public static final int aW = 2;
        private static final /* synthetic */ int[] jxk = {aV, aW};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean csw() {
        return aU == EnumC0327a.aV;
    }

    public static String u() {
        return "0.4.0";
    }

    private static int csx() {
        try {
            String[] split = "0.4.0".split("\\.");
            if (split.length > 2) {
                return (Integer.parseInt(split[1]) * 10) + (Integer.parseInt(split[0]) * 100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 20;
    }
}
