package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes.dex */
public class t {
    private static i iyv = null;
    private static boolean iyw = true;
    private static boolean iyx = true;

    private static i ccJ() {
        if (iyv == null) {
            iyw = com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                iyv = (i) runTask.getData();
            }
        }
        return iyv;
    }

    public static String ar(String str, boolean z) {
        if (z) {
            if (iyx && ccJ() != null) {
                return ccJ().S(str, true);
            }
            return str;
        } else if (iyx && iyw && ccJ() != null) {
            return ccJ().qX(str);
        } else {
            return str;
        }
    }

    public static String qY(String str) {
        if (ccJ() != null) {
            return ccJ().qY(str);
        }
        return null;
    }

    public static void d(Context context, String str, int i) {
        if (ccJ() != null) {
            ccJ().d(context, str, i);
        }
    }

    public static void an(Context context, String str) {
        if (ccJ() != null) {
            ccJ().an(context, str);
        }
    }

    public static void ao(Context context, String str) {
        if (iyx && iyw && ccJ() != null) {
            ccJ().ao(context, str);
        }
    }

    public static void qZ(String str) {
        if (iyx && iyw && ccJ() != null) {
            ccJ().qZ(str);
        }
    }

    public static void clearCache(Context context) {
        if (ccJ() != null) {
            ccJ().clearCache(context);
        }
    }

    public static String ra(String str) {
        if (ccJ() != null) {
            return ccJ().ra(str);
        }
        return null;
    }

    public static void pR(boolean z) {
        iyw = z;
    }

    public static void ccK() {
        iyx = com.baidu.adp.lib.b.d.ft().af("android_video_cache_open") == 1;
    }
}
