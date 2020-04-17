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
    private static i khI = null;
    private static boolean khJ = true;
    private static boolean khK = true;

    private static i cKi() {
        if (khI == null) {
            khJ = com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                khI = (i) runTask.getData();
            }
        }
        return khI;
    }

    public static String aC(String str, boolean z) {
        if (z) {
            if (khK && cKi() != null) {
                return cKi().ab(str, true);
            }
            return str;
        } else if (khK && khJ && cKi() != null) {
            return cKi().xS(str);
        } else {
            return str;
        }
    }

    public static String xT(String str) {
        if (cKi() != null) {
            return cKi().xT(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (cKi() != null) {
            cKi().d(context, str, i);
        }
    }

    public static void aB(Context context, String str) {
        if (cKi() != null) {
            cKi().aB(context, str);
        }
    }

    public static void aC(Context context, String str) {
        if (khK && khJ && cKi() != null) {
            cKi().aC(context, str);
        }
    }

    public static void xU(String str) {
        if (khK && khJ && cKi() != null) {
            cKi().xU(str);
        }
    }

    public static void clearCache(Context context) {
        if (cKi() != null) {
            cKi().clearCache(context);
        }
    }

    public static String xV(String str) {
        if (cKi() != null) {
            return cKi().xV(str);
        }
        return null;
    }

    public static void sZ(boolean z) {
        khJ = z;
    }

    public static void cKj() {
        khK = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
