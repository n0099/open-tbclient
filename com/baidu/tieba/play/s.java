package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class s {
    private static i ggV = null;
    private static boolean ggW = true;
    private static boolean ggX = true;

    private static i bkJ() {
        if (ggV == null) {
            ggW = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                ggV = (i) runTask.getData();
            }
        }
        return ggV;
    }

    public static String P(String str, boolean z) {
        if (z) {
            if (ggX && bkJ() != null) {
                return bkJ().n(str, true);
            }
            return str;
        } else if (ggX && ggW && bkJ() != null) {
            return bkJ().is(str);
        } else {
            return str;
        }
    }

    public static String it(String str) {
        if (bkJ() != null) {
            return bkJ().it(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (bkJ() != null) {
            bkJ().f(context, str, i);
        }
    }

    public static void ac(Context context, String str) {
        if (bkJ() != null) {
            bkJ().ac(context, str);
        }
    }

    public static void ad(Context context, String str) {
        if (ggX && ggW && bkJ() != null) {
            bkJ().ad(context, str);
        }
    }

    public static void iu(String str) {
        if (ggX && ggW && bkJ() != null) {
            bkJ().iu(str);
        }
    }

    public static void bj(Context context) {
        if (bkJ() != null) {
            bkJ().bj(context);
        }
    }

    public static void lx(boolean z) {
        ggW = z;
    }

    public static void bkK() {
        ggX = com.baidu.adp.lib.b.d.hv().ax("android_video_cache_open") == 1;
    }
}
