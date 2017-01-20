package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class at {
    private static x eTo = null;
    private static boolean eTp = true;
    private static boolean eTq = true;

    private static x aYu() {
        if (eTo == null) {
            eTp = com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, x.class);
            if (runTask != null) {
                eTo = (x) runTask.getData();
            }
        }
        return eTo;
    }

    public static String hd(String str) {
        if (eTq && eTp && aYu() != null) {
            return aYu().hd(str);
        }
        return str;
    }

    public static String he(String str) {
        if (aYu() != null) {
            return aYu().he(str);
        }
        return null;
    }

    public static void G(Context context, String str) {
        if (aYu() != null) {
            aYu().G(context, str);
        }
    }

    public static void H(Context context, String str) {
        if (eTq && eTp && aYu() != null) {
            aYu().H(context, str);
        }
    }

    public static void hf(String str) {
        if (eTq && eTp && aYu() != null) {
            aYu().hf(str);
        }
    }

    public static void av(Context context) {
        if (aYu() != null) {
            aYu().av(context);
        }
    }

    public static void ku(boolean z) {
        eTp = z;
    }

    public static void aYv() {
        eTq = com.baidu.adp.lib.b.e.dL().ac("android_video_cache_open") == 1;
    }
}
