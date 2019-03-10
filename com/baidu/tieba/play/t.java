package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i hYm = null;
    private static boolean hYn = true;
    private static boolean hYo = true;

    private static i bTJ() {
        if (hYm == null) {
            hYn = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                hYm = (i) runTask.getData();
            }
        }
        return hYm;
    }

    public static String aq(String str, boolean z) {
        if (z) {
            if (hYo && bTJ() != null) {
                return bTJ().R(str, true);
            }
            return str;
        } else if (hYo && hYn && bTJ() != null) {
            return bTJ().qD(str);
        } else {
            return str;
        }
    }

    public static String qE(String str) {
        if (bTJ() != null) {
            return bTJ().qE(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (bTJ() != null) {
            bTJ().g(context, str, i);
        }
    }

    public static void aE(Context context, String str) {
        if (bTJ() != null) {
            bTJ().aE(context, str);
        }
    }

    public static void aF(Context context, String str) {
        if (hYo && hYn && bTJ() != null) {
            bTJ().aF(context, str);
        }
    }

    public static void qF(String str) {
        if (hYo && hYn && bTJ() != null) {
            bTJ().qF(str);
        }
    }

    public static void clearCache(Context context) {
        if (bTJ() != null) {
            bTJ().clearCache(context);
        }
    }

    public static String qG(String str) {
        if (bTJ() != null) {
            return bTJ().qG(str);
        }
        return null;
    }

    public static void pd(boolean z) {
        hYn = z;
    }

    public static void bTK() {
        hYo = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
