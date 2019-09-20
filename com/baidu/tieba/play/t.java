package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i izY = null;
    private static boolean izZ = true;
    private static boolean iAa = true;

    private static i cfI() {
        if (izY == null) {
            izZ = com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                izY = (i) runTask.getData();
            }
        }
        return izY;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (iAa && cfI() != null) {
                return cfI().V(str, true);
            }
            return str;
        } else if (iAa && izZ && cfI() != null) {
            return cfI().sn(str);
        } else {
            return str;
        }
    }

    public static String so(String str) {
        if (cfI() != null) {
            return cfI().so(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (cfI() != null) {
            cfI().f(context, str, i);
        }
    }

    public static void aq(Context context, String str) {
        if (cfI() != null) {
            cfI().aq(context, str);
        }
    }

    public static void ar(Context context, String str) {
        if (iAa && izZ && cfI() != null) {
            cfI().ar(context, str);
        }
    }

    public static void sp(String str) {
        if (iAa && izZ && cfI() != null) {
            cfI().sp(str);
        }
    }

    public static void clearCache(Context context) {
        if (cfI() != null) {
            cfI().clearCache(context);
        }
    }

    public static String sq(String str) {
        if (cfI() != null) {
            return cfI().sq(str);
        }
        return null;
    }

    public static void qk(boolean z) {
        izZ = z;
    }

    public static void cfJ() {
        iAa = com.baidu.adp.lib.b.d.hS().az("android_video_cache_open") == 1;
    }
}
