package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash itJ;
    private static a itK;
    public static boolean itL;
    private String itI;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        itK = aVar;
    }

    static {
        itL = false;
        itL = h.hH().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash chW() {
        if (itJ == null) {
            synchronized (BdNativeCrash.class) {
                if (itJ == null) {
                    itJ = new BdNativeCrash();
                }
            }
        }
        return itJ;
    }

    public void ea(String str, String str2) {
        this.itI = str2;
        d.fk().initial(str);
        if (!TextUtils.isEmpty(this.itI)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.itI, true, false, false));
        }
    }
}
