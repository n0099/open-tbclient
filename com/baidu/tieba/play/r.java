package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r {
    private static h fBF = null;
    private static boolean fBG = true;
    private static boolean fBH = true;

    private static h bfX() {
        if (fBF == null) {
            fBG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, h.class);
            if (runTask != null) {
                fBF = (h) runTask.getData();
            }
        }
        return fBF;
    }

    public static String hw(String str) {
        if (fBH && fBG && bfX() != null) {
            return bfX().hw(str);
        }
        return str;
    }

    public static String hx(String str) {
        if (bfX() != null) {
            return bfX().hx(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (bfX() != null) {
            bfX().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fBH && fBG && bfX() != null) {
            bfX().ag(context, str);
        }
    }

    public static void hy(String str) {
        if (fBH && fBG && bfX() != null) {
            bfX().hy(str);
        }
    }

    public static void bf(Context context) {
        if (bfX() != null) {
            bfX().bf(context);
        }
    }

    public static void lE(boolean z) {
        fBG = z;
    }

    public static void bfY() {
        fBH = com.baidu.adp.lib.b.d.eW().af("android_video_cache_open") == 1;
    }
}
