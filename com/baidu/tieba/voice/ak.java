package com.baidu.tieba.voice;

import android.os.Build;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f2621a = new String[0];
    private static final String[] b = {"meizu"};

    public static String a(int i) {
        TiebaApplication g = TiebaApplication.g();
        return g == null ? "" : g.getString(i);
    }

    public static final boolean a() {
        String str = Build.MODEL;
        if (str == null) {
            return false;
        }
        return str.toLowerCase().startsWith("mi");
    }

    public static boolean b() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < b.length; i++) {
            if (b[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        String str = Build.MODEL;
        if (str == null) {
            return true;
        }
        for (int i = 0; i < f2621a.length; i++) {
            if (f2621a[i].equals(str)) {
                return false;
            }
        }
        return true;
    }
}
