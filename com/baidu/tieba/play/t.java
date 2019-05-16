package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i iqz = null;
    private static boolean iqA = true;
    private static boolean iqB = true;

    private static i cbI() {
        if (iqz == null) {
            iqA = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                iqz = (i) runTask.getData();
            }
        }
        return iqz;
    }

    public static String as(String str, boolean z) {
        if (z) {
            if (iqB && cbI() != null) {
                return cbI().T(str, true);
            }
            return str;
        } else if (iqB && iqA && cbI() != null) {
            return cbI().rL(str);
        } else {
            return str;
        }
    }

    public static String rM(String str) {
        if (cbI() != null) {
            return cbI().rM(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (cbI() != null) {
            cbI().f(context, str, i);
        }
    }

    public static void ar(Context context, String str) {
        if (cbI() != null) {
            cbI().ar(context, str);
        }
    }

    public static void as(Context context, String str) {
        if (iqB && iqA && cbI() != null) {
            cbI().as(context, str);
        }
    }

    public static void rN(String str) {
        if (iqB && iqA && cbI() != null) {
            cbI().rN(str);
        }
    }

    public static void clearCache(Context context) {
        if (cbI() != null) {
            cbI().clearCache(context);
        }
    }

    public static String rO(String str) {
        if (cbI() != null) {
            return cbI().rO(str);
        }
        return null;
    }

    public static void pR(boolean z) {
        iqA = z;
    }

    public static void cbJ() {
        iqB = com.baidu.adp.lib.b.d.hI().ay("android_video_cache_open") == 1;
    }
}
