package com.baidu.ubs.analytics.d;

import android.os.Environment;
/* loaded from: classes8.dex */
public final class a {
    private static final String mjv = Environment.getExternalStorageDirectory().getPath();
    static final String mjw = mjv + "/baidu/ab/crash/";
    static final String mjx = mjv + "/baidu/ab/sdklog/";
    public static final String mjy = mjv + "/baidu/ab/sdkupdata/" + dsW() + "/";
    private static int akK = EnumC0768a.aV;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class EnumC0768a {
        public static final int aV = 1;
        public static final int aW = 2;
        private static final /* synthetic */ int[] aX = {aV, aW};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean dsV() {
        return akK == EnumC0768a.aV;
    }

    public static String u() {
        return "0.4.0";
    }

    private static int dsW() {
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
