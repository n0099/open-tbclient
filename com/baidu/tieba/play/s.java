package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s {
    private static i fHb = null;
    private static boolean fHc = true;
    private static boolean fHd = true;

    private static i bhO() {
        if (fHb == null) {
            fHc = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                fHb = (i) runTask.getData();
            }
        }
        return fHb;
    }

    public static String hB(String str) {
        if (fHd && fHc && bhO() != null) {
            return bhO().hB(str);
        }
        return str;
    }

    public static String hC(String str) {
        if (bhO() != null) {
            return bhO().hC(str);
        }
        return null;
    }

    public static void aa(Context context, String str) {
        if (bhO() != null) {
            bhO().aa(context, str);
        }
    }

    public static void ab(Context context, String str) {
        if (fHd && fHc && bhO() != null) {
            bhO().ab(context, str);
        }
    }

    public static void hD(String str) {
        if (fHd && fHc && bhO() != null) {
            bhO().hD(str);
        }
    }

    public static void be(Context context) {
        if (bhO() != null) {
            bhO().be(context);
        }
    }

    public static void lx(boolean z) {
        fHc = z;
    }

    public static void bhP() {
        fHd = com.baidu.adp.lib.b.d.eV().af("android_video_cache_open") == 1;
    }
}
