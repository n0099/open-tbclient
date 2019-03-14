package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hbR;
    private static a hbS;
    public static boolean hbT;
    private String hbQ;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hbS = aVar;
    }

    static {
        hbT = false;
        hbT = h.kK().n("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bFD() {
        if (hbR == null) {
            synchronized (BdNativeCrash.class) {
                if (hbR == null) {
                    hbR = new BdNativeCrash();
                }
            }
        }
        return hbR;
    }

    public void du(String str, String str2) {
        this.hbQ = str2;
        d.hz().ar(str);
        if (!TextUtils.isEmpty(this.hbQ)) {
            b bVar = new b();
            bVar.aq(str);
            initCrashPath(bVar.a(this.hbQ, true, false, false));
        }
    }
}
