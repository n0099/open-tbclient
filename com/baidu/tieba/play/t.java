package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i iqC = null;
    private static boolean iqD = true;
    private static boolean iqE = true;

    private static i cbL() {
        if (iqC == null) {
            iqD = com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                iqC = (i) runTask.getData();
            }
        }
        return iqC;
    }

    public static String as(String str, boolean z) {
        if (z) {
            if (iqE && cbL() != null) {
                return cbL().T(str, true);
            }
            return str;
        } else if (iqE && iqD && cbL() != null) {
            return cbL().rL(str);
        } else {
            return str;
        }
    }

    public static String rM(String str) {
        if (cbL() != null) {
            return cbL().rM(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (cbL() != null) {
            cbL().f(context, str, i);
        }
    }

    public static void ar(Context context, String str) {
        if (cbL() != null) {
            cbL().ar(context, str);
        }
    }

    public static void as(Context context, String str) {
        if (iqE && iqD && cbL() != null) {
            cbL().as(context, str);
        }
    }

    public static void rN(String str) {
        if (iqE && iqD && cbL() != null) {
            cbL().rN(str);
        }
    }

    public static void clearCache(Context context) {
        if (cbL() != null) {
            cbL().clearCache(context);
        }
    }

    public static String rO(String str) {
        if (cbL() != null) {
            return cbL().rO(str);
        }
        return null;
    }

    public static void pR(boolean z) {
        iqD = z;
    }

    public static void cbM() {
        iqE = com.baidu.adp.lib.b.d.hI().ay("android_video_cache_open") == 1;
    }
}
