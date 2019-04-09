package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hbF;
    private static a hbG;
    public static boolean hbH;
    private String hbE;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hbG = aVar;
    }

    static {
        hbH = false;
        hbH = h.kK().n("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bFA() {
        if (hbF == null) {
            synchronized (BdNativeCrash.class) {
                if (hbF == null) {
                    hbF = new BdNativeCrash();
                }
            }
        }
        return hbF;
    }

    public void dv(String str, String str2) {
        this.hbE = str2;
        d.hz().ar(str);
        if (!TextUtils.isEmpty(this.hbE)) {
            b bVar = new b();
            bVar.aq(str);
            initCrashPath(bVar.a(this.hbE, true, false, false));
        }
    }
}
