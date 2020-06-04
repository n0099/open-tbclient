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
    private static i kAN = null;
    private static boolean kAO = true;
    private static boolean kAP = true;

    private static i cRv() {
        if (kAN == null) {
            kAO = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                kAN = (i) runTask.getData();
            }
        }
        return kAN;
    }

    public static String aP(String str, boolean z) {
        if (z) {
            if (kAP && cRv() != null) {
                return cRv().ao(str, true);
            }
            return str;
        } else if (kAP && kAO && cRv() != null) {
            return cRv().zB(str);
        } else {
            return str;
        }
    }

    public static String zC(String str) {
        if (cRv() != null) {
            return cRv().zC(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (cRv() != null) {
            cRv().d(context, str, i);
        }
    }

    public static void aq(Context context, String str) {
        if (cRv() != null) {
            cRv().aq(context, str);
        }
    }

    public static void ar(Context context, String str) {
        if (kAP && kAO && cRv() != null) {
            cRv().ar(context, str);
        }
    }

    public static void zD(String str) {
        if (kAP && kAO && cRv() != null) {
            cRv().zD(str);
        }
    }

    public static void clearCache(Context context) {
        if (cRv() != null) {
            cRv().clearCache(context);
        }
    }

    public static String zE(String str) {
        if (cRv() != null) {
            return cRv().zE(str);
        }
        return null;
    }

    public static void tx(boolean z) {
        kAO = z;
    }

    public static void cRw() {
        kAP = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
