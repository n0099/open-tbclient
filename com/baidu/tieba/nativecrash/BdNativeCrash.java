package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash itv;
    private static a itw;
    public static boolean itx;
    private String itu;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        itw = aVar;
    }

    static {
        itx = false;
        itx = h.hH().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash chT() {
        if (itv == null) {
            synchronized (BdNativeCrash.class) {
                if (itv == null) {
                    itv = new BdNativeCrash();
                }
            }
        }
        return itv;
    }

    public void ea(String str, String str2) {
        this.itu = str2;
        d.fk().initial(str);
        if (!TextUtils.isEmpty(this.itu)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.itu, true, false, false));
        }
    }
}
