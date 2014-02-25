package com.baidu.tieba.voice;

import com.baidu.tieba.util.cb;
import java.io.File;
/* loaded from: classes.dex */
public class aj {
    public static String a() {
        return com.baidu.adp.lib.util.j.a();
    }

    public static String a(String str) {
        if (com.baidu.adp.lib.util.m.a(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String b(String str) {
        return com.baidu.tieba.util.af.a(str, 1);
    }

    public static String c(String str) {
        return com.baidu.adp.lib.util.c.b(a(str));
    }

    public static boolean d(String str) {
        if (com.baidu.adp.lib.util.m.a(str)) {
            return false;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("FileHelper", "DelFile", "error = " + th.getMessage());
            cb.b("", -1103, "FileHelper DelFile error: " + th.getMessage(), str);
            return false;
        }
    }
}
