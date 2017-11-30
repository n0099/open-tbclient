package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s {
    private static i fQh = null;
    private static boolean fQi = true;
    private static boolean fQj = true;

    private static i bjy() {
        if (fQh == null) {
            fQi = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                fQh = (i) runTask.getData();
            }
        }
        return fQh;
    }

    public static String T(String str, boolean z) {
        if (z) {
            if (fQj && bjy() != null) {
                return bjy().r(str, true);
            }
            return str;
        } else if (fQj && fQi && bjy() != null) {
            return bjy().hE(str);
        } else {
            return str;
        }
    }

    public static String hF(String str) {
        if (bjy() != null) {
            return bjy().hF(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (bjy() != null) {
            bjy().f(context, str, i);
        }
    }

    public static void ab(Context context, String str) {
        if (bjy() != null) {
            bjy().ab(context, str);
        }
    }

    public static void ac(Context context, String str) {
        if (fQj && fQi && bjy() != null) {
            bjy().ac(context, str);
        }
    }

    public static void hG(String str) {
        if (fQj && fQi && bjy() != null) {
            bjy().hG(str);
        }
    }

    public static void bj(Context context) {
        if (bjy() != null) {
            bjy().bj(context);
        }
    }

    public static void lY(boolean z) {
        fQi = z;
    }

    public static void bjz() {
        fQj = com.baidu.adp.lib.b.d.eV().af("android_video_cache_open") == 1;
    }
}
