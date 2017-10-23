package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s {
    private static i fxF = null;
    private static boolean fxG = true;
    private static boolean fxH = true;

    private static i beu() {
        if (fxF == null) {
            fxG = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                fxF = (i) runTask.getData();
            }
        }
        return fxF;
    }

    public static String hs(String str) {
        if (fxH && fxG && beu() != null) {
            return beu().hs(str);
        }
        return str;
    }

    public static String ht(String str) {
        if (beu() != null) {
            return beu().ht(str);
        }
        return null;
    }

    public static void aa(Context context, String str) {
        if (beu() != null) {
            beu().aa(context, str);
        }
    }

    public static void ab(Context context, String str) {
        if (fxH && fxG && beu() != null) {
            beu().ab(context, str);
        }
    }

    public static void hu(String str) {
        if (fxH && fxG && beu() != null) {
            beu().hu(str);
        }
    }

    public static void be(Context context) {
        if (beu() != null) {
            beu().be(context);
        }
    }

    public static void lw(boolean z) {
        fxG = z;
    }

    public static void bev() {
        fxH = com.baidu.adp.lib.b.d.eV().af("android_video_cache_open") == 1;
    }
}
