package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash juv;
    private static a juw;
    public static boolean jux;
    private String juu;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        juw = aVar;
    }

    static {
        jux = false;
        jux = h.mn().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash czx() {
        if (juv == null) {
            synchronized (BdNativeCrash.class) {
                if (juv == null) {
                    juv = new BdNativeCrash();
                }
            }
        }
        return juv;
    }

    public void eO(String str, String str2) {
        this.juu = str2;
        d.jR().initial(str);
        if (!TextUtils.isEmpty(this.juu)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.juu, true, false, false));
        }
    }
}
