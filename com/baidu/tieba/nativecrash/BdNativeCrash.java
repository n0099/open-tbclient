package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hsZ;
    private static a hta;
    public static boolean htb;
    private String hsY;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hta = aVar;
    }

    static {
        htb = false;
        htb = h.jE().h("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bNn() {
        if (hsZ == null) {
            synchronized (BdNativeCrash.class) {
                if (hsZ == null) {
                    hsZ = new BdNativeCrash();
                }
            }
        }
        return hsZ;
    }

    public void dH(String str, String str2) {
        this.hsY = str2;
        d.gt().aa(str);
        if (!TextUtils.isEmpty(this.hsY)) {
            b bVar = new b();
            bVar.Z(str);
            initCrashPath(bVar.a(this.hsY, true, false, false));
        }
    }
}
