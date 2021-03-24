package com.baidu.ubs.analytics.d;

import android.os.Environment;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22884a = Environment.getExternalStorageDirectory().getPath();

    /* renamed from: b  reason: collision with root package name */
    public static final String f22885b = f22884a + "/baidu/ab/crash/";

    /* renamed from: c  reason: collision with root package name */
    public static final String f22886c = f22884a + "/baidu/ab/sdklog/";

    /* renamed from: d  reason: collision with root package name */
    public static int f22887d = EnumC0234a.aV;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.ubs.analytics.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class EnumC0234a {
        public static final int aV = 1;
        public static final int aW = 2;
        public static final /* synthetic */ int[] aX = {1, 2};
    }

    static {
        r0 = f22884a + "/baidu/ab/sdkupdata/" + b() + "/";
    }

    public static boolean a() {
        return f22887d == EnumC0234a.aV;
    }

    public static int b() {
        try {
            String[] split = "0.4.0".split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            if (split.length > 2) {
                return (Integer.parseInt(split[0]) * 100) + (Integer.parseInt(split[1]) * 10);
            }
            return 20;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 20;
        }
    }

    public static String c() {
        return "0.4.0";
    }
}
