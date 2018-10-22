package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i gvR = null;
    private static boolean gvS = true;
    private static boolean gvT = true;

    private static i bqE() {
        if (gvR == null) {
            gvS = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                gvR = (i) runTask.getData();
            }
        }
        return gvR;
    }

    public static String X(String str, boolean z) {
        if (z) {
            if (gvT && bqE() != null) {
                return bqE().v(str, true);
            }
            return str;
        } else if (gvT && gvS && bqE() != null) {
            return bqE().jg(str);
        } else {
            return str;
        }
    }

    public static String jh(String str) {
        if (bqE() != null) {
            return bqE().jh(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (bqE() != null) {
            bqE().g(context, str, i);
        }
    }

    public static void ar(Context context, String str) {
        if (bqE() != null) {
            bqE().ar(context, str);
        }
    }

    public static void as(Context context, String str) {
        if (gvT && gvS && bqE() != null) {
            bqE().as(context, str);
        }
    }

    public static void ji(String str) {
        if (gvT && gvS && bqE() != null) {
            bqE().ji(str);
        }
    }

    public static void clearCache(Context context) {
        if (bqE() != null) {
            bqE().clearCache(context);
        }
    }

    public static String jj(String str) {
        if (bqE() != null) {
            return bqE().jj(str);
        }
        return null;
    }

    public static void mo(boolean z) {
        gvS = z;
    }

    public static void bqF() {
        gvT = com.baidu.adp.lib.b.d.iR().aO("android_video_cache_open") == 1;
    }
}
