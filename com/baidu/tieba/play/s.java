package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class s {
    private static i fQd = null;
    private static boolean fQe = true;
    private static boolean fQf = true;

    private static i bgR() {
        if (fQd == null) {
            fQe = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                fQd = (i) runTask.getData();
            }
        }
        return fQd;
    }

    public static String P(String str, boolean z) {
        if (z) {
            if (fQf && bgR() != null) {
                return bgR().o(str, true);
            }
            return str;
        } else if (fQf && fQe && bgR() != null) {
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
        if (fQf && fQe && bgR() != null) {
            bgR().Z(context, str);
        }
    }

    public static void hR(String str) {
        if (fQf && fQe && bgR() != null) {
            bgR().hR(str);
        }
    }

    public static void aZ(Context context) {
        if (bgR() != null) {
            bgR().aZ(context);
        }
    }

    public static void lv(boolean z) {
        fQe = z;
    }

    public static void bgS() {
        fQf = com.baidu.adp.lib.b.d.eE().ak("android_video_cache_open") == 1;
    }
}
