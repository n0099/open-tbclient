package com.baidu.ubs.analytics.d;

import android.os.Environment;
/* loaded from: classes6.dex */
public final class a {
    private static final String aP = Environment.getExternalStorageDirectory().getPath();
    static final String aQ = aP + "/baidu/ab/crash/";
    static final String aR = aP + "/baidu/ab/sdklog/";
    public static final String aS = aP + "/baidu/ab/sdkupdata/" + ejO() + "/";
    private static int apL = EnumC0928a.aV;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class EnumC0928a {
        public static final int aV = 1;
        public static final int aW = 2;
        private static final /* synthetic */ int[] aX = {aV, aW};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ejN() {
        return apL == EnumC0928a.aV;
    }

    public static String u() {
        return "0.4.0";
    }

    private static int ejO() {
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
