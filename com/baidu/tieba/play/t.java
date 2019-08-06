package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i ixW = null;
    private static boolean ixX = true;
    private static boolean ixY = true;

    private static i ceU() {
        if (ixW == null) {
            ixX = com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                ixW = (i) runTask.getData();
            }
        }
        return ixW;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (ixY && ceU() != null) {
                return ceU().V(str, true);
            }
            return str;
        } else if (ixY && ixX && ceU() != null) {
            return ceU().sc(str);
        } else {
            return str;
        }
    }

    public static String sd(String str) {
        if (ceU() != null) {
            return ceU().sd(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (ceU() != null) {
            ceU().f(context, str, i);
        }
    }

    public static void aq(Context context, String str) {
        if (ceU() != null) {
            ceU().aq(context, str);
        }
    }

    public static void ar(Context context, String str) {
        if (ixY && ixX && ceU() != null) {
            ceU().ar(context, str);
        }
    }

    public static void se(String str) {
        if (ixY && ixX && ceU() != null) {
            ceU().se(str);
        }
    }

    public static void clearCache(Context context) {
        if (ceU() != null) {
            ceU().clearCache(context);
        }
    }

    public static String sf(String str) {
        if (ceU() != null) {
            return ceU().sf(str);
        }
        return null;
    }

    public static void qh(boolean z) {
        ixX = z;
    }

    public static void ceV() {
        ixY = com.baidu.adp.lib.b.d.hS().az("android_video_cache_open") == 1;
    }
}
