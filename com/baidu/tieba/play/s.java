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
    private static i jxN = null;
    private static boolean jxO = true;
    private static boolean jxP = true;

    private static i czD() {
        if (jxN == null) {
            jxO = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                jxN = (i) runTask.getData();
            }
        }
        return jxN;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (jxP && czD() != null) {
                return czD().W(str, true);
            }
            return str;
        } else if (jxP && jxO && czD() != null) {
            return czD().wG(str);
        } else {
            return str;
        }
    }

    public static String wH(String str) {
        if (czD() != null) {
            return czD().wH(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (czD() != null) {
            czD().d(context, str, i);
        }
    }

    public static void aH(Context context, String str) {
        if (czD() != null) {
            czD().aH(context, str);
        }
    }

    public static void aI(Context context, String str) {
        if (jxP && jxO && czD() != null) {
            czD().aI(context, str);
        }
    }

    public static void wI(String str) {
        if (jxP && jxO && czD() != null) {
            czD().wI(str);
        }
    }

    public static void clearCache(Context context) {
        if (czD() != null) {
            czD().clearCache(context);
        }
    }

    public static String wJ(String str) {
        if (czD() != null) {
            return czD().wJ(str);
        }
        return null;
    }

    public static void rV(boolean z) {
        jxO = z;
    }

    public static void czE() {
        jxP = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
