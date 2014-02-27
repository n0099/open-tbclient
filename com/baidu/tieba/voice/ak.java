package com.baidu.tieba.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public final class ak {
    private static final String[] a = new String[0];
    private static final String[] b = {"meizu"};

    public static String a(int i) {
        Application b2 = TiebaApplication.g().b();
        return b2 == null ? "" : b2.getString(i);
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
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(str)) {
                return false;
            }
        }
        return true;
    }
}
