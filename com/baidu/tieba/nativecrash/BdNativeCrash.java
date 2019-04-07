package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hbE;
    private static a hbF;
    public static boolean hbG;
    private String hbD;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hbF = aVar;
    }

    static {
        hbG = false;
        hbG = h.kK().n("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bFA() {
        if (hbE == null) {
            synchronized (BdNativeCrash.class) {
                if (hbE == null) {
                    hbE = new BdNativeCrash();
                }
            }
        }
        return hbE;
    }

    public void dv(String str, String str2) {
        this.hbD = str2;
        d.hz().ar(str);
        if (!TextUtils.isEmpty(this.hbD)) {
            b bVar = new b();
            bVar.aq(str);
            initCrashPath(bVar.a(this.hbD, true, false, false));
        }
    }
}
