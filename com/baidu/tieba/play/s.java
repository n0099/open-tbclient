package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s {
    private static i fRf = null;
    private static boolean fRg = true;
    private static boolean fRh = true;

    private static i bjG() {
        if (fRf == null) {
            fRg = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                fRf = (i) runTask.getData();
            }
        }
        return fRf;
    }

    public static String U(String str, boolean z) {
        if (z) {
            if (fRh && bjG() != null) {
                return bjG().s(str, true);
            }
            return str;
        } else if (fRh && fRg && bjG() != null) {
            return bjG().hC(str);
        } else {
            return str;
        }
    }

    public static String hD(String str) {
        if (bjG() != null) {
            return bjG().hD(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (bjG() != null) {
            bjG().f(context, str, i);
        }
    }

    public static void aa(Context context, String str) {
        if (bjG() != null) {
            bjG().aa(context, str);
        }
    }

    public static void ab(Context context, String str) {
        if (fRh && fRg && bjG() != null) {
            bjG().ab(context, str);
        }
    }

    public static void hE(String str) {
        if (fRh && fRg && bjG() != null) {
            bjG().hE(str);
        }
    }

    public static void bg(Context context) {
        if (bjG() != null) {
            bjG().bg(context);
        }
    }

    public static void ma(boolean z) {
        fRg = z;
    }

    public static void bjH() {
        fRh = com.baidu.adp.lib.b.d.eV().af("android_video_cache_open") == 1;
    }
}
