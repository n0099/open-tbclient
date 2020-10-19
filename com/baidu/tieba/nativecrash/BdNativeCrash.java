package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes22.dex */
public class BdNativeCrash {
    private static BdNativeCrash kIJ;
    private static a kIK;
    public static boolean kIL;
    private String kII;

    /* loaded from: classes22.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        kIK = aVar;
    }

    static {
        kIL = false;
        kIL = h.oj().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cZA() {
        if (kIJ == null) {
            synchronized (BdNativeCrash.class) {
                if (kIJ == null) {
                    kIJ = new BdNativeCrash();
                }
            }
        }
        return kIJ;
    }

    public void fI(String str, String str2) {
        this.kII = str2;
        d.lL().initial(str);
        if (!TextUtils.isEmpty(this.kII)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.kII, true, false, false));
        }
    }
}
