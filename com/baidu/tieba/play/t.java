package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i gve = null;
    private static boolean gvf = true;
    private static boolean gvg = true;

    private static i blK() {
        if (gve == null) {
            gvf = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                gve = (i) runTask.getData();
            }
        }
        return gve;
    }

    public static String T(String str, boolean z) {
        if (z) {
            if (gvg && blK() != null) {
                return blK().q(str, true);
            }
            return str;
        } else if (gvg && gvf && blK() != null) {
            return blK().hW(str);
        } else {
            return str;
        }
    }

    public static String hX(String str) {
        if (blK() != null) {
            return blK().hX(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (blK() != null) {
            blK().f(context, str, i);
        }
    }

    public static void ad(Context context, String str) {
        if (blK() != null) {
            blK().ad(context, str);
        }
    }

    public static void ae(Context context, String str) {
        if (gvg && gvf && blK() != null) {
            blK().ae(context, str);
        }
    }

    public static void hY(String str) {
        if (gvg && gvf && blK() != null) {
            blK().hY(str);
        }
    }

    public static void bo(Context context) {
        if (blK() != null) {
            blK().bo(context);
        }
    }

    public static void lQ(boolean z) {
        gvf = z;
    }

    public static void blL() {
        gvg = com.baidu.adp.lib.b.d.mA().an("android_video_cache_open") == 1;
    }
}
