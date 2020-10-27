package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes22.dex */
public class BdNativeCrash {
    private static BdNativeCrash kVg;
    private static a kVh;
    public static boolean kVi;
    private String kVf;

    /* loaded from: classes22.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        kVh = aVar;
    }

    static {
        kVi = false;
        kVi = h.oj().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash dcI() {
        if (kVg == null) {
            synchronized (BdNativeCrash.class) {
                if (kVg == null) {
                    kVg = new BdNativeCrash();
                }
            }
        }
        return kVg;
    }

    public void fN(String str, String str2) {
        this.kVf = str2;
        d.lL().initial(str);
        if (!TextUtils.isEmpty(this.kVf)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.kVf, true, false, false));
        }
    }
}
