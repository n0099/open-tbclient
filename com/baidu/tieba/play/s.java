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
    private static i jwa = null;
    private static boolean jwb = true;
    private static boolean jwc = true;

    private static i czh() {
        if (jwa == null) {
            jwb = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                jwa = (i) runTask.getData();
            }
        }
        return jwa;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (jwc && czh() != null) {
                return czh().W(str, true);
            }
            return str;
        } else if (jwc && jwb && czh() != null) {
            return czh().wE(str);
        } else {
            return str;
        }
    }

    public static String wF(String str) {
        if (czh() != null) {
            return czh().wF(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (czh() != null) {
            czh().d(context, str, i);
        }
    }

    public static void aH(Context context, String str) {
        if (czh() != null) {
            czh().aH(context, str);
        }
    }

    public static void aI(Context context, String str) {
        if (jwc && jwb && czh() != null) {
            czh().aI(context, str);
        }
    }

    public static void wG(String str) {
        if (jwc && jwb && czh() != null) {
            czh().wG(str);
        }
    }

    public static void clearCache(Context context) {
        if (czh() != null) {
            czh().clearCache(context);
        }
    }

    public static String wH(String str) {
        if (czh() != null) {
            return czh().wH(str);
        }
        return null;
    }

    public static void rP(boolean z) {
        jwb = z;
    }

    public static void czi() {
        jwc = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
