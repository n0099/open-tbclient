package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class at {
    private static x eXk = null;
    private static boolean eXl = true;
    private static boolean eXm = true;

    private static x aZj() {
        if (eXk == null) {
            eXl = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, x.class);
            if (runTask != null) {
                eXk = (x) runTask.getData();
            }
        }
        return eXk;
    }

    public static String gW(String str) {
        if (eXm && eXl && aZj() != null) {
            return aZj().gW(str);
        }
        return str;
    }

    public static String gX(String str) {
        if (aZj() != null) {
            return aZj().gX(str);
        }
        return null;
    }

    public static void ae(Context context, String str) {
        if (aZj() != null) {
            aZj().ae(context, str);
        }
    }

    public static void af(Context context, String str) {
        if (eXm && eXl && aZj() != null) {
            aZj().af(context, str);
        }
    }

    public static void gY(String str) {
        if (eXm && eXl && aZj() != null) {
            aZj().gY(str);
        }
    }

    public static void aV(Context context) {
        if (aZj() != null) {
            aZj().aV(context);
        }
    }

    public static void kA(boolean z) {
        eXl = z;
    }

    public static void aZk() {
        eXm = com.baidu.adp.lib.b.e.eZ().Y("android_video_cache_open") == 1;
    }
}
