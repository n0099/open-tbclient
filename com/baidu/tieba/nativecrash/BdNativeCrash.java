package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes16.dex */
public class BdNativeCrash {
    private static BdNativeCrash kkR;
    private static a kkS;
    public static boolean kkT;
    private String kkQ;

    /* loaded from: classes16.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        kkS = aVar;
    }

    static {
        kkT = false;
        kkT = h.oc().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cSl() {
        if (kkR == null) {
            synchronized (BdNativeCrash.class) {
                if (kkR == null) {
                    kkR = new BdNativeCrash();
                }
            }
        }
        return kkR;
    }

    public void fn(String str, String str2) {
        this.kkQ = str2;
        d.lG().initial(str);
        if (!TextUtils.isEmpty(this.kkQ)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.kkQ, true, false, false));
        }
    }
}
