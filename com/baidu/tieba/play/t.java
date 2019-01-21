package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class t {
    private static i gIe = null;
    private static boolean gIf = true;
    private static boolean gIg = true;

    private static i btn() {
        if (gIe == null) {
            gIf = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016479, i.class);
            if (runTask != null) {
                gIe = (i) runTask.getData();
            }
        }
        return gIe;
    }

    public static String Y(String str, boolean z) {
        if (z) {
            if (gIg && btn() != null) {
                return btn().x(str, true);
            }
            return str;
        } else if (gIg && gIf && btn() != null) {
            return btn().jR(str);
        } else {
            return str;
        }
    }

    public static String jS(String str) {
        if (btn() != null) {
            return btn().jS(str);
        }
        return null;
    }

    public static void g(Context context, String str, int i) {
        if (btn() != null) {
            btn().g(context, str, i);
        }
    }

    public static void aq(Context context, String str) {
        if (btn() != null) {
            btn().aq(context, str);
        }
    }

    public static void ar(Context context, String str) {
        if (gIg && gIf && btn() != null) {
            btn().ar(context, str);
        }
    }

    public static void jT(String str) {
        if (gIg && gIf && btn() != null) {
            btn().jT(str);
        }
    }

    public static void clearCache(Context context) {
        if (btn() != null) {
            btn().clearCache(context);
        }
    }

    public static String jU(String str) {
        if (btn() != null) {
            return btn().jU(str);
        }
        return null;
    }

    public static void mF(boolean z) {
        gIf = z;
    }

    public static void bto() {
        gIg = com.baidu.adp.lib.b.d.iQ().aO("android_video_cache_open") == 1;
    }
}
