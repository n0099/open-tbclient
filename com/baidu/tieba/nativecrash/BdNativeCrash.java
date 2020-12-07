package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes22.dex */
public class BdNativeCrash {
    private static BdNativeCrash loV;
    private static a loW;
    public static boolean loX;
    private String loU;

    /* loaded from: classes22.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        loW = aVar;
    }

    static {
        loX = false;
        loX = h.oi().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash djT() {
        if (loV == null) {
            synchronized (BdNativeCrash.class) {
                if (loV == null) {
                    loV = new BdNativeCrash();
                }
            }
        }
        return loV;
    }

    public void fS(String str, String str2) {
        this.loU = str2;
        d.lL().initial(str);
        if (!TextUtils.isEmpty(this.loU)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.loU, true, false, false));
        }
    }
}
