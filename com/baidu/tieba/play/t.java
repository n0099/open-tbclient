package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class t {
    private static i ixE = null;
    private static boolean ixF = true;
    private static boolean ixG = true;

    private static i ccH() {
        if (ixE == null) {
            ixF = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                ixE = (i) runTask.getData();
            }
        }
        return ixE;
    }

    public static String ar(String str, boolean z) {
        if (z) {
            if (ixG && ccH() != null) {
                return ccH().S(str, true);
            }
            return str;
        } else if (ixG && ixF && ccH() != null) {
            return ccH().qX(str);
        } else {
            return str;
        }
    }

    public static String qY(String str) {
        if (ccH() != null) {
            return ccH().qY(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (ccH() != null) {
            ccH().d(context, str, i);
        }
    }

    public static void an(Context context, String str) {
        if (ccH() != null) {
            ccH().an(context, str);
        }
    }

    public static void ao(Context context, String str) {
        if (ixG && ixF && ccH() != null) {
            ccH().ao(context, str);
        }
    }

    public static void qZ(String str) {
        if (ixG && ixF && ccH() != null) {
            ccH().qZ(str);
        }
    }

    public static void clearCache(Context context) {
        if (ccH() != null) {
            ccH().clearCache(context);
        }
    }

    public static String ra(String str) {
        if (ccH() != null) {
            return ccH().ra(str);
        }
        return null;
    }

    public static void pR(boolean z) {
        ixF = z;
    }

    public static void ccI() {
        ixG = com.baidu.adp.lib.b.d.ft().af("android_video_cache_open") == 1;
    }
}
