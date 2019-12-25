package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes6.dex */
public class BdNativeCrash {
    private static BdNativeCrash inW;
    private static a inX;
    public static boolean inY;
    private String inV;

    /* loaded from: classes6.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        inX = aVar;
    }

    static {
        inY = false;
        inY = h.hu().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cfg() {
        if (inW == null) {
            synchronized (BdNativeCrash.class) {
                if (inW == null) {
                    inW = new BdNativeCrash();
                }
            }
        }
        return inW;
    }

    public void dP(String str, String str2) {
        this.inV = str2;
        d.fj().initial(str);
        if (!TextUtils.isEmpty(this.inV)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.inV, true, false, false));
        }
    }
}
