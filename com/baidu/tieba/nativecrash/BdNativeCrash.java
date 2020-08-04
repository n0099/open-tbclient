package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes16.dex */
public class BdNativeCrash {
    private static BdNativeCrash jVv;
    private static a jVw;
    public static boolean jVx;
    private String jVu;

    /* loaded from: classes16.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        jVw = aVar;
    }

    static {
        jVx = false;
        jVx = h.mD().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cHw() {
        if (jVv == null) {
            synchronized (BdNativeCrash.class) {
                if (jVv == null) {
                    jVv = new BdNativeCrash();
                }
            }
        }
        return jVv;
    }

    public void eW(String str, String str2) {
        this.jVu = str2;
        d.kh().initial(str);
        if (!TextUtils.isEmpty(this.jVu)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.jVu, true, false, false));
        }
    }
}
