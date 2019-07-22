package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hzm;
    private static a hzn;
    public static boolean hzo;
    private String hzl;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hzn = aVar;
    }

    static {
        hzo = false;
        hzo = h.jN().h("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bPW() {
        if (hzm == null) {
            synchronized (BdNativeCrash.class) {
                if (hzm == null) {
                    hzm = new BdNativeCrash();
                }
            }
        }
        return hzm;
    }

    public void dI(String str, String str2) {
        this.hzl = str2;
        d.gC().aa(str);
        if (!TextUtils.isEmpty(this.hzl)) {
            b bVar = new b();
            bVar.Z(str);
            initCrashPath(bVar.a(this.hzl, true, false, false));
        }
    }
}
