package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class au {
    private static x fmn = null;
    private static boolean fmo = true;
    private static boolean fmp = true;

    private static x bck() {
        if (fmn == null) {
            fmo = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, x.class);
            if (runTask != null) {
                fmn = (x) runTask.getData();
            }
        }
        return fmn;
    }

    public static String hm(String str) {
        if (fmp && fmo && bck() != null) {
            return bck().hm(str);
        }
        return str;
    }

    public static String hn(String str) {
        if (bck() != null) {
            return bck().hn(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (bck() != null) {
            bck().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fmp && fmo && bck() != null) {
            bck().ag(context, str);
        }
    }

    public static void ho(String str) {
        if (fmp && fmo && bck() != null) {
            bck().ho(str);
        }
    }

    public static void aY(Context context) {
        if (bck() != null) {
            bck().aY(context);
        }
    }

    public static void lb(boolean z) {
        fmo = z;
    }

    public static void bcl() {
        fmp = com.baidu.adp.lib.b.e.eY().ad("android_video_cache_open") == 1;
    }
}
