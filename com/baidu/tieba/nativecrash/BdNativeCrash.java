package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash jfs;
    private static a jft;
    public static boolean jfu;
    private String jfr;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        jft = aVar;
    }

    static {
        jfu = false;
        jfu = h.ml().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash csV() {
        if (jfs == null) {
            synchronized (BdNativeCrash.class) {
                if (jfs == null) {
                    jfs = new BdNativeCrash();
                }
            }
        }
        return jfs;
    }

    public void en(String str, String str2) {
        this.jfr = str2;
        d.jP().initial(str);
        if (!TextUtils.isEmpty(this.jfr)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.jfr, true, false, false));
        }
    }
}
