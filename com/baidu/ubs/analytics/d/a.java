package com.baidu.ubs.analytics.d;

import android.os.Environment;
/* loaded from: classes2.dex */
public final class a {
    private static final String hCW = Environment.getExternalStorageDirectory().getPath();
    static final String hCX = hCW + "/baidu/ab/crash/";
    static final String hCY = hCW + "/baidu/ab/sdklog/";
    public static final String Sy = hCW + "/baidu/ab/sdkupdata/" + bJp() + "/";
    private static int hCZ = EnumC0265a.aV;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class EnumC0265a {
        public static final int aV = 1;
        public static final int aW = 2;
        private static final /* synthetic */ int[] hDa = {aV, aW};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bJo() {
        return hCZ == EnumC0265a.aV;
    }

    public static String u() {
        return "0.4.0";
    }

    private static int bJp() {
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
