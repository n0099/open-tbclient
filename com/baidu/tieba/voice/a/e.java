package com.baidu.tieba.voice.a;

import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.be;
import java.io.File;
/* loaded from: classes.dex */
public class e {
    public static d a(String str) {
        d dVar = new d();
        if (str == null) {
            dVar.c = 6;
            dVar.d = d.a(dVar.c);
        } else if (!af.a(af.d() + SwitchKey.VOICE)) {
            dVar.c = 7;
            dVar.d = d.a(dVar.c);
        } else {
            String a2 = be.a(af.i(str));
            if (a2 == null) {
                dVar.c = 5;
                dVar.d = d.a(dVar.c);
            } else {
                String a3 = af.a(a2, 1, true);
                if (af.g(str, a3)) {
                    dVar.b = a3;
                    dVar.f2595a = a2;
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
        if (af.a(str, bArr, 1) == null) {
            return af.e() < ((long) bArr.length) ? 2 : 1;
        }
        return 0;
    }

    public static boolean a(String str, String str2) {
        return af.g(str, af.a(str2, 1, true));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(af.d() + SwitchKey.VOICE);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
