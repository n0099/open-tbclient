package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i gxs = null;
    private static boolean gxt = true;
    private static boolean gxu = true;

    private static i bqa() {
        if (gxs == null) {
            gxt = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                gxs = (i) runTask.getData();
            }
        }
        return gxs;
    }

    public static String X(String str, boolean z) {
        if (z) {
            if (gxu && bqa() != null) {
                return bqa().v(str, true);
            }
            return str;
        } else if (gxu && gxt && bqa() != null) {
            return bqa().ji(str);
        } else {
            return str;
        }
    }

    public static String jj(String str) {
        if (bqa() != null) {
            return bqa().jj(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (bqa() != null) {
            bqa().g(context, str, i);
        }
    }

    public static void ap(Context context, String str) {
        if (bqa() != null) {
            bqa().ap(context, str);
        }
    }

    public static void aq(Context context, String str) {
        if (gxu && gxt && bqa() != null) {
            bqa().aq(context, str);
        }
    }

    public static void jk(String str) {
        if (gxu && gxt && bqa() != null) {
            bqa().jk(str);
        }
    }

    public static void clearCache(Context context) {
        if (bqa() != null) {
            bqa().clearCache(context);
        }
    }

    public static String jl(String str) {
        if (bqa() != null) {
            return bqa().jl(str);
        }
        return null;
    }

    public static void mz(boolean z) {
        gxt = z;
    }

    public static void bqb() {
        gxu = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
