package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i hYg = null;
    private static boolean hYh = true;
    private static boolean hYi = true;

    private static i bTL() {
        if (hYg == null) {
            hYh = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                hYg = (i) runTask.getData();
            }
        }
        return hYg;
    }

    public static String aq(String str, boolean z) {
        if (z) {
            if (hYi && bTL() != null) {
                return bTL().R(str, true);
            }
            return str;
        } else if (hYi && hYh && bTL() != null) {
            return bTL().qB(str);
        } else {
            return str;
        }
    }

    public static String qC(String str) {
        if (bTL() != null) {
            return bTL().qC(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (bTL() != null) {
            bTL().g(context, str, i);
        }
    }

    public static void aD(Context context, String str) {
        if (bTL() != null) {
            bTL().aD(context, str);
        }
    }

    public static void aE(Context context, String str) {
        if (hYi && hYh && bTL() != null) {
            bTL().aE(context, str);
        }
    }

    public static void qD(String str) {
        if (hYi && hYh && bTL() != null) {
            bTL().qD(str);
        }
    }

    public static void clearCache(Context context) {
        if (bTL() != null) {
            bTL().clearCache(context);
        }
    }

    public static String qE(String str) {
        if (bTL() != null) {
            return bTL().qE(str);
        }
        return null;
    }

    public static void pd(boolean z) {
        hYh = z;
    }

    public static void bTM() {
        hYi = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
