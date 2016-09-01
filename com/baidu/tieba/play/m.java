package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class m {
    private static e eWE = aZW();
    private static boolean eWF = true;
    private static boolean eWG = true;

    private static e aZW() {
        eWF = com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("prefs_save_paled_video", true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, e.class);
        if (runTask != null) {
            return (e) runTask.getData();
        }
        return null;
    }

    public static String gZ(String str) {
        if (eWG && eWF && eWE != null) {
            return eWE.gZ(str);
        }
        return str;
    }

    public static String ha(String str) {
        if (eWE != null) {
            return eWE.ha(str);
        }
        return null;
    }

    public static void G(Context context, String str) {
        if (eWE != null) {
            eWE.G(context, str);
        }
    }

    public static void H(Context context, String str) {
        if (eWG && eWF && eWE != null) {
            eWE.H(context, str);
        }
    }

    public static void hb(String str) {
        if (eWG && eWF && eWE != null) {
            eWE.hb(str);
        }
    }

    public static void ax(Context context) {
        if (eWE != null) {
            eWE.ax(context);
        }
    }

    public static void aw(Context context) {
        if (eWE != null) {
            eWE.aw(context);
        }
    }

    public static void jV(boolean z) {
        eWF = z;
    }

    public static void aZX() {
        eWG = com.baidu.adp.lib.c.e.dN().ac("android_video_cache_open") == 1;
    }
}
