package com.baidu.tieba.voice.a;

import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.ad;
import com.baidu.tieba.util.bu;
import java.io.File;
/* loaded from: classes.dex */
public class e {
    public static d a(String str) {
        d dVar = new d();
        if (str == null) {
            dVar.c = 6;
            dVar.d = d.a(dVar.c);
        } else if (!ad.a(ad.d() + SwitchKey.VOICE)) {
            dVar.c = 7;
            dVar.d = d.a(dVar.c);
        } else {
            String a = bu.a(ad.i(str));
            if (a == null) {
                dVar.c = 5;
                dVar.d = d.a(dVar.c);
            } else {
                String a2 = ad.a(a, 1, true);
                if (ad.f(str, a2)) {
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
        if (ad.a(str, bArr, 1) == null) {
            return ad.e() < ((long) bArr.length) ? 2 : 1;
        }
        return 0;
    }

    public static boolean a(String str, String str2) {
        return ad.f(str, ad.a(str2, 1, true));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(ad.d() + SwitchKey.VOICE);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
