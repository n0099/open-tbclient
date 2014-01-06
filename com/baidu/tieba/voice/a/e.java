package com.baidu.tieba.voice.a;

import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.bm;
import java.io.File;
/* loaded from: classes.dex */
public class e {
    public static d a(String str) {
        d dVar = new d();
        if (str == null) {
            dVar.c = 6;
            dVar.d = d.a(dVar.c);
        } else if (!aa.a(aa.d() + SwitchKey.VOICE)) {
            dVar.c = 7;
            dVar.d = d.a(dVar.c);
        } else {
            String a = bm.a(aa.i(str));
            if (a == null) {
                dVar.c = 5;
                dVar.d = d.a(dVar.c);
            } else {
                String a2 = aa.a(a, 1, true);
                if (aa.f(str, a2)) {
                    dVar.b = a2;
                    dVar.a = a;
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
        if (aa.a(str, bArr, 1) == null) {
            return aa.e() < ((long) bArr.length) ? 2 : 1;
        }
        return 0;
    }

    public static boolean a(String str, String str2) {
        return aa.f(str, aa.a(str2, 1, true));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(aa.d() + SwitchKey.VOICE);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
