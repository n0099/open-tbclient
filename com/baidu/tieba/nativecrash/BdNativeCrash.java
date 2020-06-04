package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes9.dex */
public class BdNativeCrash {
    private static BdNativeCrash jvB;
    private static a jvC;
    public static boolean jvD;
    private String jvA;

    /* loaded from: classes9.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        jvC = aVar;
    }

    static {
        jvD = false;
        jvD = h.mn().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash czO() {
        if (jvB == null) {
            synchronized (BdNativeCrash.class) {
                if (jvB == null) {
                    jvB = new BdNativeCrash();
                }
            }
        }
        return jvB;
    }

    public void eO(String str, String str2) {
        this.jvA = str2;
        d.jR().initial(str);
        if (!TextUtils.isEmpty(this.jvA)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.jvA, true, false, false));
        }
    }
}
