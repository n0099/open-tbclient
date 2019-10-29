package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes4.dex */
public class BdNativeCrash {
    private static BdNativeCrash hAJ;
    private static a hAK;
    public static boolean hAL;
    private String hAI;

    /* loaded from: classes4.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        hAK = aVar;
    }

    static {
        hAL = false;
        hAL = h.gX().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash bNW() {
        if (hAJ == null) {
            synchronized (BdNativeCrash.class) {
                if (hAJ == null) {
                    hAJ = new BdNativeCrash();
                }
            }
        }
        return hAJ;
    }

    public void dw(String str, String str2) {
        this.hAI = str2;
        d.eP().initial(str);
        if (!TextUtils.isEmpty(this.hAI)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.hAI, true, false, false));
        }
    }
}
