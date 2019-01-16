package com.baidu.ubs.analytics.d;

import android.os.Environment;
/* loaded from: classes6.dex */
public final class a {
    private static final String ihB = Environment.getExternalStorageDirectory().getPath();
    static final String ihC = ihB + "/baidu/ab/crash/";
    static final String ihD = ihB + "/baidu/ab/sdklog/";
    public static final String ihE = ihB + "/baidu/ab/sdkupdata/" + bTz() + "/";
    private static int aU = EnumC0349a.aV;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class EnumC0349a {
        public static final int aV = 1;
        public static final int aW = 2;
        private static final /* synthetic */ int[] ihF = {aV, aW};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bTy() {
        return aU == EnumC0349a.aV;
    }

    public static String u() {
        return "0.4.0";
    }

    private static int bTz() {
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
