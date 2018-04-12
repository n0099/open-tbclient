package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class s {
    private static i fQg = null;
    private static boolean fQh = true;
    private static boolean fQi = true;

    private static i bgR() {
        if (fQg == null) {
            fQh = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                fQg = (i) runTask.getData();
            }
        }
        return fQg;
    }

    public static String P(String str, boolean z) {
        if (z) {
            if (fQi && bgR() != null) {
                return bgR().o(str, true);
            }
            return str;
        } else if (fQi && fQh && bgR() != null) {
            return bgR().hP(str);
        } else {
            return str;
        }
    }

    public static String hQ(String str) {
        if (bgR() != null) {
            return bgR().hQ(str);
        }
        return null;
    }

    public static void e(Context context, String str, int i) {
        if (bgR() != null) {
            bgR().e(context, str, i);
        }
    }

    public static void Y(Context context, String str) {
        if (bgR() != null) {
            bgR().Y(context, str);
        }
    }

    public static void Z(Context context, String str) {
        if (fQi && fQh && bgR() != null) {
            bgR().Z(context, str);
        }
    }

    public static void hR(String str) {
        if (fQi && fQh && bgR() != null) {
            bgR().hR(str);
        }
    }

    public static void aZ(Context context) {
        if (bgR() != null) {
            bgR().aZ(context);
        }
    }

    public static void lv(boolean z) {
        fQh = z;
    }

    public static void bgS() {
        fQi = com.baidu.adp.lib.b.d.eE().ak("android_video_cache_open") == 1;
    }
}
