package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class at {
    private static x eTk = null;
    private static boolean eTl = true;
    private static boolean eTm = true;

    private static x aWI() {
        if (eTk == null) {
            eTl = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, x.class);
            if (runTask != null) {
                eTk = (x) runTask.getData();
            }
        }
        return eTk;
    }

    public static String gU(String str) {
        if (eTm && eTl && aWI() != null) {
            return aWI().gU(str);
        }
        return str;
    }

    public static String gV(String str) {
        if (aWI() != null) {
            return aWI().gV(str);
        }
        return null;
    }

    public static void ae(Context context, String str) {
        if (aWI() != null) {
            aWI().ae(context, str);
        }
    }

    public static void af(Context context, String str) {
        if (eTm && eTl && aWI() != null) {
            aWI().af(context, str);
        }
    }

    public static void gW(String str) {
        if (eTm && eTl && aWI() != null) {
            aWI().gW(str);
        }
    }

    public static void aY(Context context) {
        if (aWI() != null) {
            aWI().aY(context);
        }
    }

    public static void kh(boolean z) {
        eTl = z;
    }

    public static void aWJ() {
        eTm = com.baidu.adp.lib.b.e.eZ().Y("android_video_cache_open") == 1;
    }
}
