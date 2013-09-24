package com.baidu.tieba.voice;

import com.baidu.tieba.util.av;
import java.io.File;
/* loaded from: classes.dex */
public class aj {
    public static String a() {
        return com.baidu.adp.lib.f.g.a();
    }

    public static String a(String str) {
        if (com.baidu.adp.lib.f.h.a(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String b(String str) {
        return com.baidu.tieba.voice.a.e.a(str);
    }

    public static String c(String str) {
        return com.baidu.adp.lib.f.b.b(a(str));
    }

    public static boolean d(String str) {
        if (com.baidu.adp.lib.f.h.a(str)) {
            return false;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th) {
            av.b("FileHelper", "DelFile", "error = " + th.getMessage());
            return false;
        }
    }
}
