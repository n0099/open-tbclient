package com.baidu.tieba.nativecrash;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.b;
import com.baidu.adp.lib.Disk.d;
import com.baidu.adp.lib.util.h;
/* loaded from: classes16.dex */
public class BdNativeCrash {
    private static BdNativeCrash jVt;
    private static a jVu;
    public static boolean jVv;
    private String jVs;

    /* loaded from: classes16.dex */
    public interface a {
    }

    static native boolean initCrashPath(String str);

    public void a(a aVar) {
        jVu = aVar;
    }

    static {
        jVv = false;
        jVv = h.mD().loadLibrary("nativecrashlog", 1);
    }

    private BdNativeCrash() {
    }

    public static BdNativeCrash cHw() {
        if (jVt == null) {
            synchronized (BdNativeCrash.class) {
                if (jVt == null) {
                    jVt = new BdNativeCrash();
                }
            }
        }
        return jVt;
    }

    public void eW(String str, String str2) {
        this.jVs = str2;
        d.kh().initial(str);
        if (!TextUtils.isEmpty(this.jVs)) {
            b bVar = new b();
            bVar.setApplicationPath(str);
            initCrashPath(bVar.checkDir(this.jVs, true, false, false));
        }
    }
}
