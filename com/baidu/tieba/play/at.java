package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class at {
    private static x eWV = null;
    private static boolean eWW = true;
    private static boolean eWX = true;

    private static x aXZ() {
        if (eWV == null) {
            eWW = com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, x.class);
            if (runTask != null) {
                eWV = (x) runTask.getData();
            }
        }
        return eWV;
    }

    public static String gS(String str) {
        if (eWX && eWW && aXZ() != null) {
            return aXZ().gS(str);
        }
        return str;
    }

    public static String gT(String str) {
        if (aXZ() != null) {
            return aXZ().gT(str);
        }
        return null;
    }

    public static void aa(Context context, String str) {
        if (aXZ() != null) {
            aXZ().aa(context, str);
        }
    }

    public static void ab(Context context, String str) {
        if (eWX && eWW && aXZ() != null) {
            aXZ().ab(context, str);
        }
    }

    public static void gU(String str) {
        if (eWX && eWW && aXZ() != null) {
            aXZ().gU(str);
        }
    }

    public static void aT(Context context) {
        if (aXZ() != null) {
            aXZ().aT(context);
        }
    }

    public static void kr(boolean z) {
        eWW = z;
    }

    public static void aYa() {
        eWX = com.baidu.adp.lib.b.e.eT().ab("android_video_cache_open") == 1;
    }
}
