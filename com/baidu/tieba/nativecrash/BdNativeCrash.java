package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash jfo;
    private static a jfp;
    public static boolean jfq;
    private String jfn;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        jfp = aVar;
    }

    static {
        jfq = false;
        jfq = h.ml().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash csX() {
        if (jfo == null) {
            synchronized (BdNativeCrash.class) {
                if (jfo == null) {
                    jfo = new BdNativeCrash();
                }
            }
        }
        return jfo;
    }

    public void en(String str, String str2) {
        this.jfn = str2;
        d.jP().initial(str);
        if (!TextUtils.isEmpty(this.jfn)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.jfn, true, false, false));
        }
    }
}
