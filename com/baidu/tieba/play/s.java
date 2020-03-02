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
    private static i jwc = null;
    private static boolean jwd = true;
    private static boolean jwe = true;

    private static i czj() {
        if (jwc == null) {
            jwd = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                jwc = (i) runTask.getData();
            }
        }
        return jwc;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (jwe && czj() != null) {
                return czj().W(str, true);
            }
            return str;
        } else if (jwe && jwd && czj() != null) {
            return czj().wE(str);
        } else {
            return str;
        }
    }

    public static String wF(String str) {
        if (czj() != null) {
            return czj().wF(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (czj() != null) {
            czj().d(context, str, i);
        }
    }

    public static void aH(Context context, String str) {
        if (czj() != null) {
            czj().aH(context, str);
        }
    }

    public static void aI(Context context, String str) {
        if (jwe && jwd && czj() != null) {
            czj().aI(context, str);
        }
    }

    public static void wG(String str) {
        if (jwe && jwd && czj() != null) {
            czj().wG(str);
        }
    }

    public static void clearCache(Context context) {
        if (czj() != null) {
            czj().clearCache(context);
        }
    }

    public static String wH(String str) {
        if (czj() != null) {
            return czj().wH(str);
        }
        return null;
    }

    public static void rP(boolean z) {
        jwd = z;
    }

    public static void czk() {
        jwe = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
