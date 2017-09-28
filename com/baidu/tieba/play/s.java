package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class s {
    private static i fxU = null;
    private static boolean fxV = true;
    private static boolean fxW = true;

    private static i beA() {
        if (fxU == null) {
            fxV = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                fxU = (i) runTask.getData();
            }
        }
        return fxU;
    }

    public static String ht(String str) {
        if (fxW && fxV && beA() != null) {
            return beA().ht(str);
        }
        return str;
    }

    public static String hu(String str) {
        if (beA() != null) {
            return beA().hu(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (beA() != null) {
            beA().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fxW && fxV && beA() != null) {
            beA().ag(context, str);
        }
    }

    public static void hv(String str) {
        if (fxW && fxV && beA() != null) {
            beA().hv(str);
        }
    }

    public static void bf(Context context) {
        if (beA() != null) {
            beA().bf(context);
        }
    }

    public static void lx(boolean z) {
        fxV = z;
    }

    public static void beB() {
        fxW = com.baidu.adp.lib.b.d.eV().af("android_video_cache_open") == 1;
    }
}
