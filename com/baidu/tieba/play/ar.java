package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ar {
    private static v eJU = null;
    private static boolean eJV = true;
    private static boolean eJW = true;

    private static v aWH() {
        if (eJU == null) {
            eJV = com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, v.class);
            if (runTask != null) {
                eJU = (v) runTask.getData();
            }
        }
        return eJU;
    }

    public static String hc(String str) {
        if (eJW && eJV && aWH() != null) {
            return aWH().hc(str);
        }
        return str;
    }

    public static String hd(String str) {
        if (aWH() != null) {
            return aWH().hd(str);
        }
        return null;
    }

    public static void G(Context context, String str) {
        if (aWH() != null) {
            aWH().G(context, str);
        }
    }

    public static void H(Context context, String str) {
        if (eJW && eJV && aWH() != null) {
            aWH().H(context, str);
        }
    }

    public static void he(String str) {
        if (eJW && eJV && aWH() != null) {
            aWH().he(str);
        }
    }

    public static void at(Context context) {
        if (aWH() != null) {
            aWH().at(context);
        }
    }

    public static void kk(boolean z) {
        eJV = z;
    }

    public static void aWI() {
        eJW = com.baidu.adp.lib.c.e.dN().ac("android_video_cache_open") == 1;
    }
}
