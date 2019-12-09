package com.baidu.ubs.analytics.d;

import android.os.Environment;
/* loaded from: classes3.dex */
public final class a {
    private static final String jXP = Environment.getExternalStorageDirectory().getPath();
    static final String jXQ = jXP + "/baidu/ab/crash/";
    static final String jXR = jXP + "/baidu/ab/sdklog/";
    public static final String jXS = jXP + "/baidu/ab/sdkupdata/" + cBB() + "/";
    private static int aU = EnumC0548a.aV;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class EnumC0548a {
        public static final int aV = 1;
        public static final int aW = 2;
        private static final /* synthetic */ int[] jXT = {aV, aW};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean cBA() {
        return aU == EnumC0548a.aV;
    }

    public static String u() {
        return "0.4.0";
    }

    private static int cBB() {
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
