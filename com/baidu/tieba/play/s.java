package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class s {
    private static i gcv = null;
    private static boolean gcw = true;
    private static boolean gcx = true;

    private static i blP() {
        if (gcv == null) {
            gcw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                gcv = (i) runTask.getData();
            }
        }
        return gcv;
    }

    public static String P(String str, boolean z) {
        if (z) {
            if (gcx && blP() != null) {
                return blP().o(str, true);
            }
            return str;
        } else if (gcx && gcw && blP() != null) {
            return blP().ip(str);
        } else {
            return str;
        }
    }

    public static String iq(String str) {
        if (blP() != null) {
            return blP().iq(str);
        }
        return null;
    }

    public static void e(Context context, String str, int i) {
        if (blP() != null) {
            blP().e(context, str, i);
        }
    }

    public static void aa(Context context, String str) {
        if (blP() != null) {
            blP().aa(context, str);
        }
    }

    public static void ab(Context context, String str) {
        if (gcx && gcw && blP() != null) {
            blP().ab(context, str);
        }
    }

    public static void ir(String str) {
        if (gcx && gcw && blP() != null) {
            blP().ir(str);
        }
    }

    public static void bj(Context context) {
        if (blP() != null) {
            blP().bj(context);
        }
    }

    public static void lC(boolean z) {
        gcw = z;
    }

    public static void blQ() {
        gcx = com.baidu.adp.lib.b.d.hv().aw("android_video_cache_open") == 1;
    }
}
