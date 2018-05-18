package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class s {
    private static i fRj = null;
    private static boolean fRk = true;
    private static boolean fRl = true;

    private static i bgR() {
        if (fRj == null) {
            fRk = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                fRj = (i) runTask.getData();
            }
        }
        return fRj;
    }

    public static String P(String str, boolean z) {
        if (z) {
            if (fRl && bgR() != null) {
                return bgR().o(str, true);
            }
            return str;
        } else if (fRl && fRk && bgR() != null) {
            return bgR().hQ(str);
        } else {
            return str;
        }
    }

    public static String hR(String str) {
        if (bgR() != null) {
            return bgR().hR(str);
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
        if (fRl && fRk && bgR() != null) {
            bgR().Z(context, str);
        }
    }

    public static void hS(String str) {
        if (fRl && fRk && bgR() != null) {
            bgR().hS(str);
        }
    }

    public static void aZ(Context context) {
        if (bgR() != null) {
            bgR().aZ(context);
        }
    }

    public static void lw(boolean z) {
        fRk = z;
    }

    public static void bgS() {
        fRl = com.baidu.adp.lib.b.d.eE().ak("android_video_cache_open") == 1;
    }
}
