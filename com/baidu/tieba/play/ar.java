package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ar {
    private static v fgC = null;
    private static boolean fgD = true;
    private static boolean fgE = true;

    private static v bda() {
        if (fgC == null) {
            fgD = com.baidu.tbadk.core.sharedPref.b.um().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, v.class);
            if (runTask != null) {
                fgC = (v) runTask.getData();
            }
        }
        return fgC;
    }

    public static String hh(String str) {
        if (fgE && fgD && bda() != null) {
            return bda().hh(str);
        }
        return str;
    }

    public static String hi(String str) {
        if (bda() != null) {
            return bda().hi(str);
        }
        return null;
    }

    public static void G(Context context, String str) {
        if (bda() != null) {
            bda().G(context, str);
        }
    }

    public static void H(Context context, String str) {
        if (fgE && fgD && bda() != null) {
            bda().H(context, str);
        }
    }

    public static void hj(String str) {
        if (fgE && fgD && bda() != null) {
            bda().hj(str);
        }
    }

    public static void av(Context context) {
        if (bda() != null) {
            bda().av(context);
        }
    }

    public static void kA(boolean z) {
        fgD = z;
    }

    public static void bdb() {
        fgE = com.baidu.adp.lib.c.e.dN().ac("android_video_cache_open") == 1;
    }
}
