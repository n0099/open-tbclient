package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class t {
    private static i gtJ = null;
    private static boolean gtK = true;
    private static boolean gtL = true;

    private static i bky() {
        if (gtJ == null) {
            gtK = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, i.class);
            if (runTask != null) {
                gtJ = (i) runTask.getData();
            }
        }
        return gtJ;
    }

    public static String V(String str, boolean z) {
        if (z) {
            if (gtL && bky() != null) {
                return bky().r(str, true);
            }
            return str;
        } else if (gtL && gtK && bky() != null) {
            return bky().hM(str);
        } else {
            return str;
        }
    }

    public static String hN(String str) {
        if (bky() != null) {
            return bky().hN(str);
        }
        return null;
    }

    public static void f(Context context, String str, int i) {
        if (bky() != null) {
            bky().f(context, str, i);
        }
    }

    public static void ab(Context context, String str) {
        if (bky() != null) {
            bky().ab(context, str);
        }
    }

    public static void ac(Context context, String str) {
        if (gtL && gtK && bky() != null) {
            bky().ac(context, str);
        }
    }

    public static void hO(String str) {
        if (gtL && gtK && bky() != null) {
            bky().hO(str);
        }
    }

    public static void bp(Context context) {
        if (bky() != null) {
            bky().bp(context);
        }
    }

    public static void lI(boolean z) {
        gtK = z;
    }

    public static void bkz() {
        gtL = com.baidu.adp.lib.b.d.mA().an("android_video_cache_open") == 1;
    }
}
