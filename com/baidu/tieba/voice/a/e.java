package com.baidu.tieba.voice.a;

import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.p;
import java.io.File;
/* loaded from: classes.dex */
public class e {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        if (p.b(c(str))) {
            return p.d() + File.separator + SwitchKey.VOICE + File.separator + str;
        }
        return null;
    }

    private static String c(String str) {
        if (!p.a()) {
            return null;
        }
        return SwitchKey.VOICE + File.separator + str;
    }

    public static d b(String str) {
        d dVar = new d();
        if (str == null) {
            dVar.c = 6;
            dVar.d = d.a(dVar.c);
        } else if (!p.a(String.valueOf(p.d()) + SwitchKey.VOICE)) {
            dVar.c = 7;
            dVar.d = d.a(dVar.c);
        } else {
            String a2 = at.a(p.h(str));
            if (a2 == null) {
                dVar.c = 5;
                dVar.d = d.a(dVar.c);
            } else {
                String str2 = String.valueOf(p.d()) + c(a2);
                if (p.f(str, str2)) {
                    dVar.b = str2;
                    dVar.f2020a = a2;
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
        if (!p.a(String.valueOf(p.d()) + SwitchKey.VOICE)) {
            return 7;
        }
        if (p.a(c(str), bArr) == null) {
            if (p.e() < bArr.length) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static boolean a(String str, String str2) {
        return p.f(str, String.valueOf(p.d()) + c(str2));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(String.valueOf(p.d()) + SwitchKey.VOICE);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
