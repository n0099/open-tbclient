package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i gvu = null;
    private static boolean gvv = true;
    private static boolean gvw = true;

    private static i blL() {
        if (gvu == null) {
            gvv = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                gvu = (i) runTask.getData();
            }
        }
        return gvu;
    }

    public static String T(String str, boolean z) {
        if (z) {
            if (gvw && blL() != null) {
                return blL().q(str, true);
            }
            return str;
        } else if (gvw && gvv && blL() != null) {
            return blL().hW(str);
        } else {
            return str;
        }
    }

    public static String hX(String str) {
        if (blL() != null) {
            return blL().hX(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (blL() != null) {
            blL().f(context, str, i);
        }
    }

    public static void ad(Context context, String str) {
        if (blL() != null) {
            blL().ad(context, str);
        }
    }

    public static void ae(Context context, String str) {
        if (gvw && gvv && blL() != null) {
            blL().ae(context, str);
        }
    }

    public static void hY(String str) {
        if (gvw && gvv && blL() != null) {
            blL().hY(str);
        }
    }

    public static void bo(Context context) {
        if (blL() != null) {
            blL().bo(context);
        }
    }

    public static void lV(boolean z) {
        gvv = z;
    }

    public static void blM() {
        gvw = com.baidu.adp.lib.b.d.mA().an("android_video_cache_open") == 1;
    }
}
