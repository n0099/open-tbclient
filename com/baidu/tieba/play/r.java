package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r {
    private static h fzc = null;
    private static boolean fzd = true;
    private static boolean fze = true;

    private static h bfL() {
        if (fzc == null) {
            fzd = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, h.class);
            if (runTask != null) {
                fzc = (h) runTask.getData();
            }
        }
        return fzc;
    }

    public static String hs(String str) {
        if (fze && fzd && bfL() != null) {
            return bfL().hs(str);
        }
        return str;
    }

    public static String ht(String str) {
        if (bfL() != null) {
            return bfL().ht(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (bfL() != null) {
            bfL().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fze && fzd && bfL() != null) {
            bfL().ag(context, str);
        }
    }

    public static void hu(String str) {
        if (fze && fzd && bfL() != null) {
            bfL().hu(str);
        }
    }

    public static void aY(Context context) {
        if (bfL() != null) {
            bfL().aY(context);
        }
    }

    public static void lw(boolean z) {
        fzd = z;
    }

    public static void bfM() {
        fze = com.baidu.adp.lib.b.d.eW().af("android_video_cache_open") == 1;
    }
}
