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
    private static i jrE = null;
    private static boolean jrF = true;
    private static boolean jrG = true;

    private static i cwE() {
        if (jrE == null) {
            jrF = com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                jrE = (i) runTask.getData();
            }
        }
        return jrE;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (jrG && cwE() != null) {
                return cwE().W(str, true);
            }
            return str;
        } else if (jrG && jrF && cwE() != null) {
            return cwE().wg(str);
        } else {
            return str;
        }
    }

    public static String wh(String str) {
        if (cwE() != null) {
            return cwE().wh(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (cwE() != null) {
            cwE().d(context, str, i);
        }
    }

    public static void aG(Context context, String str) {
        if (cwE() != null) {
            cwE().aG(context, str);
        }
    }

    public static void aH(Context context, String str) {
        if (jrG && jrF && cwE() != null) {
            cwE().aH(context, str);
        }
    }

    public static void wi(String str) {
        if (jrG && jrF && cwE() != null) {
            cwE().wi(str);
        }
    }

    public static void clearCache(Context context) {
        if (cwE() != null) {
            cwE().clearCache(context);
        }
    }

    public static String wj(String str) {
        if (cwE() != null) {
            return cwE().wj(str);
        }
        return null;
    }

    public static void rz(boolean z) {
        jrF = z;
    }

    public static void cwF() {
        jrG = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
