package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i gEi = null;
    private static boolean gEj = true;
    private static boolean gEk = true;

    private static i brT() {
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
            if (gEk && brT() != null) {
                return brT().x(str, true);
            }
            return str;
        } else if (gEk && gEj && brT() != null) {
            return brT().jA(str);
        } else {
            return str;
        }
    }

    public static String jB(String str) {
        if (brT() != null) {
            return brT().jB(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (brT() != null) {
            brT().g(context, str, i);
        }
    }

    public static void as(Context context, String str) {
        if (brT() != null) {
            brT().as(context, str);
        }
    }

    public static void at(Context context, String str) {
        if (gEk && gEj && brT() != null) {
            brT().at(context, str);
        }
    }

    public static void jC(String str) {
        if (gEk && gEj && brT() != null) {
            brT().jC(str);
        }
    }

    public static void clearCache(Context context) {
        if (brT() != null) {
            brT().clearCache(context);
        }
    }

    public static String jD(String str) {
        if (brT() != null) {
            return brT().jD(str);
        }
        return null;
    }

    public static void mC(boolean z) {
        gEj = z;
    }

    public static void brU() {
        gEk = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
