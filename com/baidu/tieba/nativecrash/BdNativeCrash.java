package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash itx;
    private static a ity;
    public static boolean itz;
    private String itw;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        ity = aVar;
    }

    static {
        itz = false;
        itz = h.hH().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash chV() {
        if (itx == null) {
            synchronized (BdNativeCrash.class) {
                if (itx == null) {
                    itx = new BdNativeCrash();
                }
            }
        }
        return itx;
    }

    public void ea(String str, String str2) {
        this.itw = str2;
        d.fk().initial(str);
        if (!TextUtils.isEmpty(this.itw)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.itw, true, false, false));
        }
    }
}
