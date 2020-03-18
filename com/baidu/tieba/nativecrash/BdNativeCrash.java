package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash ivj;
    private static a ivk;
    public static boolean ivl;
    private String ivi;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        ivk = aVar;
    }

    static {
        ivl = false;
        ivl = h.hH().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash ciq() {
        if (ivj == null) {
            synchronized (BdNativeCrash.class) {
                if (ivj == null) {
                    ivj = new BdNativeCrash();
                }
            }
        }
        return ivj;
    }

    public void dY(String str, String str2) {
        this.ivi = str2;
        d.fk().initial(str);
        if (!TextUtils.isEmpty(this.ivi)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.ivi, true, false, false));
        }
    }
}
