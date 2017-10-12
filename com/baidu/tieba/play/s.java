package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s {
    private static i fxT = null;
    private static boolean fxU = true;
    private static boolean fxV = true;

    private static i bez() {
        if (fxT == null) {
            fxU = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                fxT = (i) runTask.getData();
            }
        }
        return fxT;
    }

    public static String ht(String str) {
        if (fxV && fxU && bez() != null) {
            return bez().ht(str);
        }
        return str;
    }

    public static String hu(String str) {
        if (bez() != null) {
            return bez().hu(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (bez() != null) {
            bez().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fxV && fxU && bez() != null) {
            bez().ag(context, str);
        }
    }

    public static void hv(String str) {
        if (fxV && fxU && bez() != null) {
            bez().hv(str);
        }
    }

    public static void bf(Context context) {
        if (bez() != null) {
            bez().bf(context);
        }
    }

    public static void lx(boolean z) {
        fxU = z;
    }

    public static void beA() {
        fxV = com.baidu.adp.lib.b.d.eV().af("android_video_cache_open") == 1;
    }
}
