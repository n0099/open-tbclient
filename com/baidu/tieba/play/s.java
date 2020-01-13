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
    private static i jvf = null;
    private static boolean jvg = true;
    private static boolean jvh = true;

    private static i cxL() {
        if (jvf == null) {
            jvg = com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                jvf = (i) runTask.getData();
            }
        }
        return jvf;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (jvh && cxL() != null) {
                return cxL().W(str, true);
            }
            return str;
        } else if (jvh && jvg && cxL() != null) {
            return cxL().wk(str);
        } else {
            return str;
        }
    }

    public static String wl(String str) {
        if (cxL() != null) {
            return cxL().wl(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (cxL() != null) {
            cxL().d(context, str, i);
        }
    }

    public static void aH(Context context, String str) {
        if (cxL() != null) {
            cxL().aH(context, str);
        }
    }

    public static void aI(Context context, String str) {
        if (jvh && jvg && cxL() != null) {
            cxL().aI(context, str);
        }
    }

    public static void wm(String str) {
        if (jvh && jvg && cxL() != null) {
            cxL().wm(str);
        }
    }

    public static void clearCache(Context context) {
        if (cxL() != null) {
            cxL().clearCache(context);
        }
    }

    public static String wn(String str) {
        if (cxL() != null) {
            return cxL().wn(str);
        }
        return null;
    }

    public static void rM(boolean z) {
        jvg = z;
    }

    public static void cxM() {
        jvh = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
