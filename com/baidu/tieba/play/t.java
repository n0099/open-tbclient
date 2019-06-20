package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i iqD = null;
    private static boolean iqE = true;
    private static boolean iqF = true;

    private static i cbM() {
        if (iqD == null) {
            iqE = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                iqD = (i) runTask.getData();
            }
        }
        return iqD;
    }

    public static String as(String str, boolean z) {
        if (z) {
            if (iqF && cbM() != null) {
                return cbM().T(str, true);
            }
            return str;
        } else if (iqF && iqE && cbM() != null) {
            return cbM().rK(str);
        } else {
            return str;
        }
    }

    public static String rL(String str) {
        if (cbM() != null) {
            return cbM().rL(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (cbM() != null) {
            cbM().f(context, str, i);
        }
    }

    public static void ar(Context context, String str) {
        if (cbM() != null) {
            cbM().ar(context, str);
        }
    }

    public static void as(Context context, String str) {
        if (iqF && iqE && cbM() != null) {
            cbM().as(context, str);
        }
    }

    public static void rM(String str) {
        if (iqF && iqE && cbM() != null) {
            cbM().rM(str);
        }
    }

    public static void clearCache(Context context) {
        if (cbM() != null) {
            cbM().clearCache(context);
        }
    }

    public static String rN(String str) {
        if (cbM() != null) {
            return cbM().rN(str);
        }
        return null;
    }

    public static void pS(boolean z) {
        iqE = z;
    }

    public static void cbN() {
        iqF = com.baidu.adp.lib.b.d.hI().ay("android_video_cache_open") == 1;
    }
}
