package com.baidu.ubs.analytics.d;

import android.os.Environment;
/* loaded from: classes.dex */
public final class a {
    private static final String hyk = Environment.getExternalStorageDirectory().getPath();
    static final String hyl = hyk + "/baidu/ab/crash/";
    static final String hym = hyk + "/baidu/ab/sdklog/";
    public static final String Sz = hyk + "/baidu/ab/sdkupdata/" + bKk() + "/";
    private static int hyn = EnumC0263a.aV;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class EnumC0263a {
        public static final int aV = 1;
        public static final int aW = 2;
        private static final /* synthetic */ int[] hyo = {aV, aW};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean bKj() {
        return hyn == EnumC0263a.aV;
    }

    public static String u() {
        return "0.4.0";
    }

    private static int bKk() {
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
