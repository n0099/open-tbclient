package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes7.dex */
public class BdNativeCrash {
    private static BdNativeCrash irA;
    private static a irB;
    public static boolean irC;
    private String irz;

    /* loaded from: classes7.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        irB = aVar;
    }

    static {
        irC = false;
        irC = h.ht().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cgo() {
        if (irA == null) {
            synchronized (BdNativeCrash.class) {
                if (irA == null) {
                    irA = new BdNativeCrash();
                }
            }
        }
        return irA;
    }

    public void dR(String str, String str2) {
        this.irz = str2;
        d.fj().initial(str);
        if (!TextUtils.isEmpty(this.irz)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.irz, true, false, false));
        }
    }
}
