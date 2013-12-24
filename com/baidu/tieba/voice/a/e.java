package com.baidu.tieba.voice.a;

import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.y;
import java.io.File;
/* loaded from: classes.dex */
public class e {
    public static d a(String str) {
        d dVar = new d();
        if (str == null) {
            dVar.c = 6;
            dVar.d = d.a(dVar.c);
        } else if (!y.a(y.d() + SwitchKey.VOICE)) {
            dVar.c = 7;
            dVar.d = d.a(dVar.c);
        } else {
            String a = bc.a(y.i(str));
            if (a == null) {
                dVar.c = 5;
                dVar.d = d.a(dVar.c);
            } else {
                String a2 = y.a(a, 1, true);
                if (y.f(str, a2)) {
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
        if (y.a(str, bArr, 1) == null) {
            return y.e() < ((long) bArr.length) ? 2 : 1;
        }
        return 0;
    }

    public static boolean a(String str, String str2) {
        return y.f(str, y.a(str2, 1, true));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(y.d() + SwitchKey.VOICE);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
