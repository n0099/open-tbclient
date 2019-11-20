package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hzS;
    private static a hzT;
    public static boolean hzU;
    private String hzR;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hzT = aVar;
    }

    static {
        hzU = false;
        hzU = h.gX().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bNU() {
        if (hzS == null) {
            synchronized (BdNativeCrash.class) {
                if (hzS == null) {
                    hzS = new BdNativeCrash();
                }
            }
        }
        return hzS;
    }

    public void dw(String str, String str2) {
        this.hzR = str2;
        d.eP().initial(str);
        if (!TextUtils.isEmpty(this.hzR)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.hzR, true, false, false));
        }
    }
}
