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
    private static i khM = null;
    private static boolean khN = true;
    private static boolean khO = true;

    private static i cKg() {
        if (khM == null) {
            khN = com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                khM = (i) runTask.getData();
            }
        }
        return khM;
    }

    public static String aC(String str, boolean z) {
        if (z) {
            if (khO && cKg() != null) {
                return cKg().ab(str, true);
            }
            return str;
        } else if (khO && khN && cKg() != null) {
            return cKg().xV(str);
        } else {
            return str;
        }
    }

    public static String xW(String str) {
        if (cKg() != null) {
            return cKg().xW(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (cKg() != null) {
            cKg().d(context, str, i);
        }
    }

    public static void ap(Context context, String str) {
        if (cKg() != null) {
            cKg().ap(context, str);
        }
    }

    public static void aq(Context context, String str) {
        if (khO && khN && cKg() != null) {
            cKg().aq(context, str);
        }
    }

    public static void xX(String str) {
        if (khO && khN && cKg() != null) {
            cKg().xX(str);
        }
    }

    public static void clearCache(Context context) {
        if (cKg() != null) {
            cKg().clearCache(context);
        }
    }

    public static String xY(String str) {
        if (cKg() != null) {
            return cKg().xY(str);
        }
        return null;
    }

    public static void sZ(boolean z) {
        khN = z;
    }

    public static void cKh() {
        khO = SwitchManager.getInstance().findType(VCacheSwitch.CACHE_SWITCH) == 1;
    }
}
