package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class t {
    private static i gEh = null;
    private static boolean gEi = true;
    private static boolean gEj = true;

    private static i bre() {
        if (gEh == null) {
            gEi = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                gEh = (i) runTask.getData();
            }
        }
        return gEh;
    }

    public static String V(String str, boolean z) {
        if (z) {
            if (gEj && bre() != null) {
                return bre().r(str, true);
            }
            return str;
        } else if (gEj && gEi && bre() != null) {
            return bre().hE(str);
        } else {
            return str;
        }
    }

    public static String hF(String str) {
        if (bre() != null) {
            return bre().hF(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (bre() != null) {
            bre().f(context, str, i);
        }
    }

    public static void ad(Context context, String str) {
        if (bre() != null) {
            bre().ad(context, str);
        }
    }

    public static void ae(Context context, String str) {
        if (gEj && gEi && bre() != null) {
            bre().ae(context, str);
        }
    }

    public static void hG(String str) {
        if (gEj && gEi && bre() != null) {
            bre().hG(str);
        }
    }

    public static void bs(Context context) {
        if (bre() != null) {
            bre().bs(context);
        }
    }

    public static void mE(boolean z) {
        gEi = z;
    }

    public static void brf() {
        gEj = com.baidu.adp.lib.b.d.mz().an("android_video_cache_open") == 1;
    }
}
