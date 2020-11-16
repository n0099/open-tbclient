package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes21.dex */
public class BdNativeCrash {
    private static BdNativeCrash lbv;
    private static a lbw;
    public static boolean lbx;
    private String lbu;

    /* loaded from: classes21.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        lbw = aVar;
    }

    static {
        lbx = false;
        lbx = h.oj().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash deH() {
        if (lbv == null) {
            synchronized (BdNativeCrash.class) {
                if (lbv == null) {
                    lbv = new BdNativeCrash();
                }
            }
        }
        return lbv;
    }

    public void fN(String str, String str2) {
        this.lbu = str2;
        d.lL().initial(str);
        if (!TextUtils.isEmpty(this.lbu)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.lbu, true, false, false));
        }
    }
}
