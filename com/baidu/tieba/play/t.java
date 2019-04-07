package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i hXS = null;
    private static boolean hXT = true;
    private static boolean hXU = true;

    private static i bTH() {
        if (hXS == null) {
            hXT = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                hXS = (i) runTask.getData();
            }
        }
        return hXS;
    }

    public static String aq(String str, boolean z) {
        if (z) {
            if (hXU && bTH() != null) {
                return bTH().R(str, true);
            }
            return str;
        } else if (hXU && hXT && bTH() != null) {
            return bTH().qC(str);
        } else {
            return str;
        }
    }

    public static String qD(String str) {
        if (bTH() != null) {
            return bTH().qD(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (bTH() != null) {
            bTH().g(context, str, i);
        }
    }

    public static void aD(Context context, String str) {
        if (bTH() != null) {
            bTH().aD(context, str);
        }
    }

    public static void aE(Context context, String str) {
        if (hXU && hXT && bTH() != null) {
            bTH().aE(context, str);
        }
    }

    public static void qE(String str) {
        if (hXU && hXT && bTH() != null) {
            bTH().qE(str);
        }
    }

    public static void clearCache(Context context) {
        if (bTH() != null) {
            bTH().clearCache(context);
        }
    }

    public static String qF(String str) {
        if (bTH() != null) {
            return bTH().qF(str);
        }
        return null;
    }

    public static void pd(boolean z) {
        hXT = z;
    }

    public static void bTI() {
        hXU = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
