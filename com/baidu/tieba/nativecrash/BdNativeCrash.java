package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes22.dex */
public class BdNativeCrash {
    private static BdNativeCrash loX;
    private static a loY;
    public static boolean loZ;
    private String loW;

    /* loaded from: classes22.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        loY = aVar;
    }

    static {
        loZ = false;
        loZ = h.oi().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash djU() {
        if (loX == null) {
            synchronized (BdNativeCrash.class) {
                if (loX == null) {
                    loX = new BdNativeCrash();
                }
            }
        }
        return loX;
    }

    public void fS(String str, String str2) {
        this.loW = str2;
        d.lL().initial(str);
        if (!TextUtils.isEmpty(this.loW)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.loW, true, false, false));
        }
    }
}
