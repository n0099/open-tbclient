package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class s {
    private static i ggw = null;
    private static boolean ggx = true;
    private static boolean ggy = true;

    private static i bmt() {
        if (ggw == null) {
            ggx = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                ggw = (i) runTask.getData();
            }
        }
        return ggw;
    }

    public static String Q(String str, boolean z) {
        if (z) {
            if (ggy && bmt() != null) {
                return bmt().o(str, true);
            }
            return str;
        } else if (ggy && ggx && bmt() != null) {
            return bmt().iu(str);
        } else {
            return str;
        }
    }

    public static String iv(String str) {
        if (bmt() != null) {
            return bmt().iv(str);
        }
        return null;
    }

    public static void e(Context context, String str, int i) {
        if (bmt() != null) {
            bmt().e(context, str, i);
        }
    }

    public static void aa(Context context, String str) {
        if (bmt() != null) {
            bmt().aa(context, str);
        }
    }

    public static void ab(Context context, String str) {
        if (ggy && ggx && bmt() != null) {
            bmt().ab(context, str);
        }
    }

    public static void iw(String str) {
        if (ggy && ggx && bmt() != null) {
            bmt().iw(str);
        }
    }

    public static void bj(Context context) {
        if (bmt() != null) {
            bmt().bj(context);
        }
    }

    public static void lM(boolean z) {
        ggx = z;
    }

    public static void bmu() {
        ggy = com.baidu.adp.lib.b.d.hv().aw("android_video_cache_open") == 1;
    }
}
