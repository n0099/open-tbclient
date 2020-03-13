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
    private static i jwo = null;
    private static boolean jwp = true;
    private static boolean jwq = true;

    private static i czk() {
        if (jwo == null) {
            jwp = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                jwo = (i) runTask.getData();
            }
        }
        return jwo;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (jwq && czk() != null) {
                return czk().W(str, true);
            }
            return str;
        } else if (jwq && jwp && czk() != null) {
            return czk().wF(str);
        } else {
            return str;
        }
    }

    public static String wG(String str) {
        if (czk() != null) {
            return czk().wG(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (czk() != null) {
            czk().d(context, str, i);
        }
    }

    public static void aH(Context context, String str) {
        if (czk() != null) {
            czk().aH(context, str);
        }
    }

    public static void aI(Context context, String str) {
        if (jwq && jwp && czk() != null) {
            czk().aI(context, str);
        }
    }

    public static void wH(String str) {
        if (jwq && jwp && czk() != null) {
            czk().wH(str);
        }
    }

    public static void clearCache(Context context) {
        if (czk() != null) {
            czk().clearCache(context);
        }
    }

    public static String wI(String str) {
        if (czk() != null) {
            return czk().wI(str);
        }
        return null;
    }

    public static void rP(boolean z) {
        jwp = z;
    }

    public static void czl() {
        jwq = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
