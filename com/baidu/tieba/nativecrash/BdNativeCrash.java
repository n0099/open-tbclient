package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hCa;
    private static a hCb;
    public static boolean hCc;
    private String hBZ;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hCb = aVar;
    }

    static {
        hCc = false;
        hCc = h.jN().h("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bQY() {
        if (hCa == null) {
            synchronized (BdNativeCrash.class) {
                if (hCa == null) {
                    hCa = new BdNativeCrash();
                }
            }
        }
        return hCa;
    }

    public void dK(String str, String str2) {
        this.hBZ = str2;
        d.gC().aa(str);
        if (!TextUtils.isEmpty(this.hBZ)) {
            b bVar = new b();
            bVar.Z(str);
            initCrashPath(bVar.a(this.hBZ, true, false, false));
        }
    }
}
