package com.baidu.tieba.voice;

import com.baidu.tieba.util.cb;
import java.io.File;
/* loaded from: classes.dex */
public final class aj {
    public static String a(String str) {
        if (com.baidu.adp.lib.util.k.a(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static boolean b(String str) {
        if (com.baidu.adp.lib.util.k.a(str)) {
            return false;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.b("FileHelper", "DelFile", "error = " + th.getMessage());
            cb.b("", -1103, "FileHelper DelFile error: " + th.getMessage(), str);
            return false;
        }
    }
}
