package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i gEi = null;
    private static boolean gEj = true;
    private static boolean gEk = true;

    private static i brS() {
        if (gEi == null) {
            gEj = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                gEi = (i) runTask.getData();
            }
        }
        return gEi;
    }

    public static String Z(String str, boolean z) {
        if (z) {
            if (gEk && brS() != null) {
                return brS().x(str, true);
            }
            return str;
        } else if (gEk && gEj && brS() != null) {
            return brS().jA(str);
        } else {
            return str;
        }
    }

    public static String jB(String str) {
        if (brS() != null) {
            return brS().jB(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (brS() != null) {
            brS().g(context, str, i);
        }
    }

    public static void as(Context context, String str) {
        if (brS() != null) {
            brS().as(context, str);
        }
    }

    public static void at(Context context, String str) {
        if (gEk && gEj && brS() != null) {
            brS().at(context, str);
        }
    }

    public static void jC(String str) {
        if (gEk && gEj && brS() != null) {
            brS().jC(str);
        }
    }

    public static void clearCache(Context context) {
        if (brS() != null) {
            brS().clearCache(context);
        }
    }

    public static String jD(String str) {
        if (brS() != null) {
            return brS().jD(str);
        }
        return null;
    }

    public static void mC(boolean z) {
        gEj = z;
    }

    public static void brT() {
        gEk = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
