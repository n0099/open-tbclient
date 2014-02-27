package com.baidu.tieba.voice.a;

import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.af;
import java.io.File;
/* loaded from: classes.dex */
public final class e {
    public static boolean a(String str, String str2) {
        return af.f(str, af.a(str2, 1, true));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(String.valueOf(af.d()) + SwitchKey.VOICE);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
