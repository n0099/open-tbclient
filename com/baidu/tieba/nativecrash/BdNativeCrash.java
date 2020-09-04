package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes16.dex */
public class BdNativeCrash {
    private static BdNativeCrash kkY;
    private static a kkZ;
    public static boolean kla;
    private String kkX;

    /* loaded from: classes16.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        kkZ = aVar;
    }

    static {
        kla = false;
        kla = h.oc().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cSm() {
        if (kkY == null) {
            synchronized (BdNativeCrash.class) {
                if (kkY == null) {
                    kkY = new BdNativeCrash();
                }
            }
        }
        return kkY;
    }

    public void fo(String str, String str2) {
        this.kkX = str2;
        d.lG().initial(str);
        if (!TextUtils.isEmpty(this.kkX)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.kkX, true, false, false));
        }
    }
}
