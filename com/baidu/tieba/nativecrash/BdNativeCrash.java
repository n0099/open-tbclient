package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash jMV;
    private static a jMW;
    public static boolean jMX;
    private String jMU;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        jMW = aVar;
    }

    static {
        jMX = false;
        jMX = h.mD().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cDN() {
        if (jMV == null) {
            synchronized (BdNativeCrash.class) {
                if (jMV == null) {
                    jMV = new BdNativeCrash();
                }
            }
        }
        return jMV;
    }

    public void eU(String str, String str2) {
        this.jMU = str2;
        d.kh().initial(str);
        if (!TextUtils.isEmpty(this.jMU)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.jMU, true, false, false));
        }
    }
}
