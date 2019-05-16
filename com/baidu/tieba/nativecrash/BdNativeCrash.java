package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hsW;
    private static a hsX;
    public static boolean hsY;
    private String hsV;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hsX = aVar;
    }

    static {
        hsY = false;
        hsY = h.jE().h("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bNk() {
        if (hsW == null) {
            synchronized (BdNativeCrash.class) {
                if (hsW == null) {
                    hsW = new BdNativeCrash();
                }
            }
        }
        return hsW;
    }

    public void dH(String str, String str2) {
        this.hsV = str2;
        d.gt().aa(str);
        if (!TextUtils.isEmpty(this.hsV)) {
            b bVar = new b();
            bVar.Z(str);
            initCrashPath(bVar.a(this.hsV, true, false, false));
        }
    }
}
