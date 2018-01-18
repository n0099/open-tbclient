package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class t {
    private static i gto = null;
    private static boolean gtp = true;
    private static boolean gtq = true;

    private static i bkx() {
        if (gto == null) {
            gtp = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                gto = (i) runTask.getData();
            }
        }
        return gto;
    }

    public static String V(String str, boolean z) {
        if (z) {
            if (gtq && bkx() != null) {
                return bkx().r(str, true);
            }
            return str;
        } else if (gtq && gtp && bkx() != null) {
            return bkx().hF(str);
        } else {
            return str;
        }
    }

    public static String hG(String str) {
        if (bkx() != null) {
            return bkx().hG(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (bkx() != null) {
            bkx().f(context, str, i);
        }
    }

    public static void ac(Context context, String str) {
        if (bkx() != null) {
            bkx().ac(context, str);
        }
    }

    public static void ad(Context context, String str) {
        if (gtq && gtp && bkx() != null) {
            bkx().ad(context, str);
        }
    }

    public static void hH(String str) {
        if (gtq && gtp && bkx() != null) {
            bkx().hH(str);
        }
    }

    public static void bs(Context context) {
        if (bkx() != null) {
            bkx().bs(context);
        }
    }

    public static void lG(boolean z) {
        gtp = z;
    }

    public static void bky() {
        gtq = com.baidu.adp.lib.b.d.mz().an("android_video_cache_open") == 1;
    }
}
