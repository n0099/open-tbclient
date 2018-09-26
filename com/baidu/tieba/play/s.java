package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class s {
    private static i goo = null;
    private static boolean gop = true;
    private static boolean goq = true;

    private static i bnp() {
        if (goo == null) {
            gop = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                goo = (i) runTask.getData();
            }
        }
        return goo;
    }

    public static String Q(String str, boolean z) {
        if (z) {
            if (goq && bnp() != null) {
                return bnp().o(str, true);
            }
            return str;
        } else if (goq && gop && bnp() != null) {
            return bnp().iT(str);
        } else {
            return str;
        }
    }

    public static String iU(String str) {
        if (bnp() != null) {
            return bnp().iU(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (bnp() != null) {
            bnp().g(context, str, i);
        }
    }

    public static void ar(Context context, String str) {
        if (bnp() != null) {
            bnp().ar(context, str);
        }
    }

    public static void as(Context context, String str) {
        if (goq && gop && bnp() != null) {
            bnp().as(context, str);
        }
    }

    public static void iV(String str) {
        if (goq && gop && bnp() != null) {
            bnp().iV(str);
        }
    }

    public static void clearCache(Context context) {
        if (bnp() != null) {
            bnp().clearCache(context);
        }
    }

    public static String iW(String str) {
        if (bnp() != null) {
            return bnp().iW(str);
        }
        return null;
    }

    public static void lW(boolean z) {
        gop = z;
    }

    public static void bnq() {
        goq = com.baidu.adp.lib.b.d.iB().aO("android_video_cache_open") == 1;
    }
}
