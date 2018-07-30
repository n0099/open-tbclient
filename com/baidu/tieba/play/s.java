package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class s {
    private static i ggW = null;
    private static boolean ggX = true;
    private static boolean ggY = true;

    private static i bkM() {
        if (ggW == null) {
            ggX = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                ggW = (i) runTask.getData();
            }
        }
        return ggW;
    }

    public static String P(String str, boolean z) {
        if (z) {
            if (ggY && bkM() != null) {
                return bkM().n(str, true);
            }
            return str;
        } else if (ggY && ggX && bkM() != null) {
            return bkM().ir(str);
        } else {
            return str;
        }
    }

    public static String is(String str) {
        if (bkM() != null) {
            return bkM().is(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (bkM() != null) {
            bkM().f(context, str, i);
        }
    }

    public static void ac(Context context, String str) {
        if (bkM() != null) {
            bkM().ac(context, str);
        }
    }

    public static void ad(Context context, String str) {
        if (ggY && ggX && bkM() != null) {
            bkM().ad(context, str);
        }
    }

    public static void it(String str) {
        if (ggY && ggX && bkM() != null) {
            bkM().it(str);
        }
    }

    public static void bk(Context context) {
        if (bkM() != null) {
            bkM().bk(context);
        }
    }

    public static void lx(boolean z) {
        ggX = z;
    }

    public static void bkN() {
        ggY = com.baidu.adp.lib.b.d.hv().ax("android_video_cache_open") == 1;
    }
}
