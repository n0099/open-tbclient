package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s {
    private static i fRa = null;
    private static boolean fRb = true;
    private static boolean fRc = true;

    private static i bjG() {
        if (fRa == null) {
            fRb = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                fRa = (i) runTask.getData();
            }
        }
        return fRa;
    }

    public static String U(String str, boolean z) {
        if (z) {
            if (fRc && bjG() != null) {
                return bjG().s(str, true);
            }
            return str;
        } else if (fRc && fRb && bjG() != null) {
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
        if (fRc && fRb && bjG() != null) {
            bjG().ab(context, str);
        }
    }

    public static void hE(String str) {
        if (fRc && fRb && bjG() != null) {
            bjG().hE(str);
        }
    }

    public static void bg(Context context) {
        if (bjG() != null) {
            bjG().bg(context);
        }
    }

    public static void ma(boolean z) {
        fRb = z;
    }

    public static void bjH() {
        fRc = com.baidu.adp.lib.b.d.eV().af("android_video_cache_open") == 1;
    }
}
