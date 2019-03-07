package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i hYl = null;
    private static boolean hYm = true;
    private static boolean hYn = true;

    private static i bTI() {
        if (hYl == null) {
            hYm = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                hYl = (i) runTask.getData();
            }
        }
        return hYl;
    }

    public static String ap(String str, boolean z) {
        if (z) {
            if (hYn && bTI() != null) {
                return bTI().Q(str, true);
            }
            return str;
        } else if (hYn && hYm && bTI() != null) {
            return bTI().qC(str);
        } else {
            return str;
        }
    }

    public static String qD(String str) {
        if (bTI() != null) {
            return bTI().qD(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (bTI() != null) {
            bTI().g(context, str, i);
        }
    }

    public static void aE(Context context, String str) {
        if (bTI() != null) {
            bTI().aE(context, str);
        }
    }

    public static void aF(Context context, String str) {
        if (hYn && hYm && bTI() != null) {
            bTI().aF(context, str);
        }
    }

    public static void qE(String str) {
        if (hYn && hYm && bTI() != null) {
            bTI().qE(str);
        }
    }

    public static void clearCache(Context context) {
        if (bTI() != null) {
            bTI().clearCache(context);
        }
    }

    public static String qF(String str) {
        if (bTI() != null) {
            return bTI().qF(str);
        }
        return null;
    }

    public static void pd(boolean z) {
        hYm = z;
    }

    public static void bTJ() {
        hYn = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
