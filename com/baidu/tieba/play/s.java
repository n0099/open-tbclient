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
    private static i kzH = null;
    private static boolean kzI = true;
    private static boolean kzJ = true;

    private static i cRf() {
        if (kzH == null) {
            kzI = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                kzH = (i) runTask.getData();
            }
        }
        return kzH;
    }

    public static String aP(String str, boolean z) {
        if (z) {
            if (kzJ && cRf() != null) {
                return cRf().ao(str, true);
            }
            return str;
        } else if (kzJ && kzI && cRf() != null) {
            return cRf().zB(str);
        } else {
            return str;
        }
    }

    public static String zC(String str) {
        if (cRf() != null) {
            return cRf().zC(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (cRf() != null) {
            cRf().d(context, str, i);
        }
    }

    public static void aq(Context context, String str) {
        if (cRf() != null) {
            cRf().aq(context, str);
        }
    }

    public static void ar(Context context, String str) {
        if (kzJ && kzI && cRf() != null) {
            cRf().ar(context, str);
        }
    }

    public static void zD(String str) {
        if (kzJ && kzI && cRf() != null) {
            cRf().zD(str);
        }
    }

    public static void clearCache(Context context) {
        if (cRf() != null) {
            cRf().clearCache(context);
        }
    }

    public static String zE(String str) {
        if (cRf() != null) {
            return cRf().zE(str);
        }
        return null;
    }

    public static void tx(boolean z) {
        kzI = z;
    }

    public static void cRg() {
        kzJ = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
