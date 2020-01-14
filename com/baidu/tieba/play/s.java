package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.switchs.VCacheSwitch;
/* loaded from: classes.dex */
public class s {
    private static i jvk = null;
    private static boolean jvl = true;
    private static boolean jvm = true;

    private static i cxN() {
        if (jvk == null) {
            jvl = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                jvk = (i) runTask.getData();
            }
        }
        return jvk;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (jvm && cxN() != null) {
                return cxN().W(str, true);
            }
            return str;
        } else if (jvm && jvl && cxN() != null) {
            return cxN().wk(str);
        } else {
            return str;
        }
    }

    public static String wl(String str) {
        if (cxN() != null) {
            return cxN().wl(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (cxN() != null) {
            cxN().d(context, str, i);
        }
    }

    public static void aH(Context context, String str) {
        if (cxN() != null) {
            cxN().aH(context, str);
        }
    }

    public static void aI(Context context, String str) {
        if (jvm && jvl && cxN() != null) {
            cxN().aI(context, str);
        }
    }

    public static void wm(String str) {
        if (jvm && jvl && cxN() != null) {
            cxN().wm(str);
        }
    }

    public static void clearCache(Context context) {
        if (cxN() != null) {
            cxN().clearCache(context);
        }
    }

    public static String wn(String str) {
        if (cxN() != null) {
            return cxN().wn(str);
        }
        return null;
    }

    public static void rM(boolean z) {
        jvl = z;
    }

    public static void cxO() {
        jvm = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
