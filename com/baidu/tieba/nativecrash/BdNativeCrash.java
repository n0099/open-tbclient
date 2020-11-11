package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes22.dex */
public class BdNativeCrash {
    private static BdNativeCrash lbd;
    private static a lbe;
    public static boolean lbf;
    private String lbc;

    /* loaded from: classes22.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        lbe = aVar;
    }

    static {
        lbf = false;
        lbf = h.oj().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash dfk() {
        if (lbd == null) {
            synchronized (BdNativeCrash.class) {
                if (lbd == null) {
                    lbd = new BdNativeCrash();
                }
            }
        }
        return lbd;
    }

    public void fN(String str, String str2) {
        this.lbc = str2;
        d.lL().initial(str);
        if (!TextUtils.isEmpty(this.lbc)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.lbc, true, false, false));
        }
    }
}
