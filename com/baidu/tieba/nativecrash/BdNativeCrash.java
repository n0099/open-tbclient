package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes21.dex */
public class BdNativeCrash {
    private static BdNativeCrash ktx;
    private static a kty;
    public static boolean ktz;
    private String ktw;

    /* loaded from: classes21.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        kty = aVar;
    }

    static {
        ktz = false;
        ktz = h.oi().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cVR() {
        if (ktx == null) {
            synchronized (BdNativeCrash.class) {
                if (ktx == null) {
                    ktx = new BdNativeCrash();
                }
            }
        }
        return ktx;
    }

    public void fB(String str, String str2) {
        this.ktw = str2;
        d.lK().initial(str);
        if (!TextUtils.isEmpty(this.ktw)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.ktw, true, false, false));
        }
    }
}
