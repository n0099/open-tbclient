package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r {
    private static h fAo = null;
    private static boolean fAp = true;
    private static boolean fAq = true;

    private static h bfV() {
        if (fAo == null) {
            fAp = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, h.class);
            if (runTask != null) {
                fAo = (h) runTask.getData();
            }
        }
        return fAo;
    }

    public static String hx(String str) {
        if (fAq && fAp && bfV() != null) {
            return bfV().hx(str);
        }
        return str;
    }

    public static String hy(String str) {
        if (bfV() != null) {
            return bfV().hy(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (bfV() != null) {
            bfV().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fAq && fAp && bfV() != null) {
            bfV().ag(context, str);
        }
    }

    public static void hz(String str) {
        if (fAq && fAp && bfV() != null) {
            bfV().hz(str);
        }
    }

    public static void aZ(Context context) {
        if (bfV() != null) {
            bfV().aZ(context);
        }
    }

    public static void lw(boolean z) {
        fAp = z;
    }

    public static void bfW() {
        fAq = com.baidu.adp.lib.b.d.fh().al("android_video_cache_open") == 1;
    }
}
