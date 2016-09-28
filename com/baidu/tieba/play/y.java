package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class y {
    private static g eZg = null;
    private static boolean eZh = true;
    private static boolean eZi = true;

    private static g baB() {
        if (eZg == null) {
            eZh = com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, g.class);
            if (runTask != null) {
                eZg = (g) runTask.getData();
            }
        }
        return eZg;
    }

    public static String hg(String str) {
        if (eZi && eZh && baB() != null) {
            return baB().hg(str);
        }
        return str;
    }

    public static String hh(String str) {
        if (baB() != null) {
            return baB().hh(str);
        }
        return null;
    }

    public static void G(Context context, String str) {
        if (baB() != null) {
            baB().G(context, str);
        }
    }

    public static void H(Context context, String str) {
        if (eZi && eZh && baB() != null) {
            baB().H(context, str);
        }
    }

    public static void hi(String str) {
        if (eZi && eZh && baB() != null) {
            baB().hi(str);
        }
    }

    public static void av(Context context) {
        if (baB() != null) {
            baB().av(context);
        }
    }

    public static void jY(boolean z) {
        eZh = z;
    }

    public static void baC() {
        eZi = com.baidu.adp.lib.c.e.dN().ac("android_video_cache_open") == 1;
    }
}
