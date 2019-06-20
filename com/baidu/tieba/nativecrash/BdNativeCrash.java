package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hta;
    private static a htb;
    public static boolean htc;
    private String hsZ;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        htb = aVar;
    }

    static {
        htc = false;
        htc = h.jE().h("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bNo() {
        if (hta == null) {
            synchronized (BdNativeCrash.class) {
                if (hta == null) {
                    hta = new BdNativeCrash();
                }
            }
        }
        return hta;
    }

    public void dH(String str, String str2) {
        this.hsZ = str2;
        d.gt().aa(str);
        if (!TextUtils.isEmpty(this.hsZ)) {
            b bVar = new b();
            bVar.Z(str);
            initCrashPath(bVar.a(this.hsZ, true, false, false));
        }
    }
}
