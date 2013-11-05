package com.baidu.tieba.voice.a;

import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.w;
import java.io.File;
/* loaded from: classes.dex */
public class e {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        if (w.b(c(str))) {
            return w.d() + File.separator + SwitchKey.VOICE + File.separator + str;
        }
        return null;
    }

    private static String c(String str) {
        if (!w.a()) {
            return null;
        }
        return SwitchKey.VOICE + File.separator + str;
    }

    public static d b(String str) {
        d dVar = new d();
        if (str == null) {
            dVar.c = 6;
            dVar.d = d.a(dVar.c);
        } else if (!w.a(w.d() + SwitchKey.VOICE)) {
            dVar.c = 7;
            dVar.d = d.a(dVar.c);
        } else {
            String a2 = bc.a(w.i(str));
            if (a2 == null) {
                dVar.c = 5;
                dVar.d = d.a(dVar.c);
            } else {
                String str2 = w.d() + c(a2);
                if (w.f(str, str2)) {
                    dVar.b = str2;
                    dVar.f2558a = a2;
                } else {
                    dVar.c = 1;
                    dVar.d = d.a(dVar.c);
                }
            }
        }
        return dVar;
    }

    public static int a(String str, byte[] bArr) {
        if (str == null) {
            return 5;
        }
        if (bArr == null || bArr.length == 0) {
            return 6;
        }
        if (!w.a(w.d() + SwitchKey.VOICE)) {
            return 7;
        }
        if (w.a(c(str), bArr) == null) {
            if (w.e() < bArr.length) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static boolean a(String str, String str2) {
        return w.f(str, w.d() + c(str2));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(w.d() + SwitchKey.VOICE);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
