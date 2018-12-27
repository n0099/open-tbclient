package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i gGZ = null;
    private static boolean gHa = true;
    private static boolean gHb = true;

    private static i bsE() {
        if (gGZ == null) {
            gHa = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                gGZ = (i) runTask.getData();
            }
        }
        return gGZ;
    }

    public static String Z(String str, boolean z) {
        if (z) {
            if (gHb && bsE() != null) {
                return bsE().x(str, true);
            }
            return str;
        } else if (gHb && gHa && bsE() != null) {
            return bsE().jB(str);
        } else {
            return str;
        }
    }

    public static String jC(String str) {
        if (bsE() != null) {
            return bsE().jC(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (bsE() != null) {
            bsE().g(context, str, i);
        }
    }

    public static void as(Context context, String str) {
        if (bsE() != null) {
            bsE().as(context, str);
        }
    }

    public static void at(Context context, String str) {
        if (gHb && gHa && bsE() != null) {
            bsE().at(context, str);
        }
    }

    public static void jD(String str) {
        if (gHb && gHa && bsE() != null) {
            bsE().jD(str);
        }
    }

    public static void clearCache(Context context) {
        if (bsE() != null) {
            bsE().clearCache(context);
        }
    }

    public static String jE(String str) {
        if (bsE() != null) {
            return bsE().jE(str);
        }
        return null;
    }

    public static void mF(boolean z) {
        gHa = z;
    }

    public static void bsF() {
        gHb = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
