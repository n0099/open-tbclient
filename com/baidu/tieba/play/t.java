package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i iwT = null;
    private static boolean iwU = true;
    private static boolean iwV = true;

    private static i ceC() {
        if (iwT == null) {
            iwU = com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                iwT = (i) runTask.getData();
            }
        }
        return iwT;
    }

    public static String aw(String str, boolean z) {
        if (z) {
            if (iwV && ceC() != null) {
                return ceC().V(str, true);
            }
            return str;
        } else if (iwV && iwU && ceC() != null) {
            return ceC().sc(str);
        } else {
            return str;
        }
    }

    public static String sd(String str) {
        if (ceC() != null) {
            return ceC().sd(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (ceC() != null) {
            ceC().f(context, str, i);
        }
    }

    public static void aq(Context context, String str) {
        if (ceC() != null) {
            ceC().aq(context, str);
        }
    }

    public static void ar(Context context, String str) {
        if (iwV && iwU && ceC() != null) {
            ceC().ar(context, str);
        }
    }

    public static void se(String str) {
        if (iwV && iwU && ceC() != null) {
            ceC().se(str);
        }
    }

    public static void clearCache(Context context) {
        if (ceC() != null) {
            ceC().clearCache(context);
        }
    }

    public static String sf(String str) {
        if (ceC() != null) {
            return ceC().sf(str);
        }
        return null;
    }

    public static void qg(boolean z) {
        iwU = z;
    }

    public static void ceD() {
        iwV = com.baidu.adp.lib.b.d.hS().az("android_video_cache_open") == 1;
    }
}
