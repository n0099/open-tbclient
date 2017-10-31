package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s {
    private static i fGw = null;
    private static boolean fGx = true;
    private static boolean fGy = true;

    private static i bhG() {
        if (fGw == null) {
            fGx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                fGw = (i) runTask.getData();
            }
        }
        return fGw;
    }

    public static String hA(String str) {
        if (fGy && fGx && bhG() != null) {
            return bhG().hA(str);
        }
        return str;
    }

    public static String hB(String str) {
        if (bhG() != null) {
            return bhG().hB(str);
        }
        return null;
    }

    public static void aa(Context context, String str) {
        if (bhG() != null) {
            bhG().aa(context, str);
        }
    }

    public static void ab(Context context, String str) {
        if (fGy && fGx && bhG() != null) {
            bhG().ab(context, str);
        }
    }

    public static void hC(String str) {
        if (fGy && fGx && bhG() != null) {
            bhG().hC(str);
        }
    }

    public static void be(Context context) {
        if (bhG() != null) {
            bhG().be(context);
        }
    }

    public static void lr(boolean z) {
        fGx = z;
    }

    public static void bhH() {
        fGy = com.baidu.adp.lib.b.d.eV().af("android_video_cache_open") == 1;
    }
}
