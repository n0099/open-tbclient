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
    private static i kUK = null;
    private static boolean kUL = true;
    private static boolean kUM = true;

    private static i cVN() {
        if (kUK == null) {
            kUL = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                kUK = (i) runTask.getData();
            }
        }
        return kUK;
    }

    public static String aR(String str, boolean z) {
        if (z) {
            if (kUM && cVN() != null) {
                return cVN().aq(str, true);
            }
            return str;
        } else if (kUM && kUL && cVN() != null) {
            return cVN().zU(str);
        } else {
            return str;
        }
    }

    public static String zV(String str) {
        if (cVN() != null) {
            return cVN().zV(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (cVN() != null) {
            cVN().d(context, str, i);
        }
    }

    public static void aq(Context context, String str) {
        if (cVN() != null) {
            cVN().aq(context, str);
        }
    }

    public static void ar(Context context, String str) {
        if (kUM && kUL && cVN() != null) {
            cVN().ar(context, str);
        }
    }

    public static void zW(String str) {
        if (kUM && kUL && cVN() != null) {
            cVN().zW(str);
        }
    }

    public static void clearCache(Context context) {
        if (cVN() != null) {
            cVN().clearCache(context);
        }
    }

    public static String zX(String str) {
        if (cVN() != null) {
            return cVN().zX(str);
        }
        return null;
    }

    public static void tL(boolean z) {
        kUL = z;
    }

    public static void cVO() {
        kUM = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
