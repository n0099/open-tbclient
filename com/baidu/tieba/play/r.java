package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r {
    private static h fAM = null;
    private static boolean fAN = true;
    private static boolean fAO = true;

    private static h bfM() {
        if (fAM == null) {
            fAN = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, h.class);
            if (runTask != null) {
                fAM = (h) runTask.getData();
            }
        }
        return fAM;
    }

    public static String hw(String str) {
        if (fAO && fAN && bfM() != null) {
            return bfM().hw(str);
        }
        return str;
    }

    public static String hx(String str) {
        if (bfM() != null) {
            return bfM().hx(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (bfM() != null) {
            bfM().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fAO && fAN && bfM() != null) {
            bfM().ag(context, str);
        }
    }

    public static void hy(String str) {
        if (fAO && fAN && bfM() != null) {
            bfM().hy(str);
        }
    }

    public static void be(Context context) {
        if (bfM() != null) {
            bfM().be(context);
        }
    }

    public static void lD(boolean z) {
        fAN = z;
    }

    public static void bfN() {
        fAO = com.baidu.adp.lib.b.d.eW().af("android_video_cache_open") == 1;
    }
}
