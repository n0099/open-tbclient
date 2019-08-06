package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hAe;
    private static a hAf;
    public static boolean hAg;
    private String hAd;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hAf = aVar;
    }

    static {
        hAg = false;
        hAg = h.jN().h("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bQk() {
        if (hAe == null) {
            synchronized (BdNativeCrash.class) {
                if (hAe == null) {
                    hAe = new BdNativeCrash();
                }
            }
        }
        return hAe;
    }

    public void dI(String str, String str2) {
        this.hAd = str2;
        d.gC().aa(str);
        if (!TextUtils.isEmpty(this.hAd)) {
            b bVar = new b();
            bVar.Z(str);
            initCrashPath(bVar.a(this.hAd, true, false, false));
        }
    }
}
