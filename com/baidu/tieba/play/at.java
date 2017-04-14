package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class at {
    private static x eUU = null;
    private static boolean eUV = true;
    private static boolean eUW = true;

    private static x aYi() {
        if (eUU == null) {
            eUV = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, x.class);
            if (runTask != null) {
                eUU = (x) runTask.getData();
            }
        }
        return eUU;
    }

    public static String gW(String str) {
        if (eUW && eUV && aYi() != null) {
            return aYi().gW(str);
        }
        return str;
    }

    public static String gX(String str) {
        if (aYi() != null) {
            return aYi().gX(str);
        }
        return null;
    }

    public static void ae(Context context, String str) {
        if (aYi() != null) {
            aYi().ae(context, str);
        }
    }

    public static void af(Context context, String str) {
        if (eUW && eUV && aYi() != null) {
            aYi().af(context, str);
        }
    }

    public static void gY(String str) {
        if (eUW && eUV && aYi() != null) {
            aYi().gY(str);
        }
    }

    public static void aV(Context context) {
        if (aYi() != null) {
            aYi().aV(context);
        }
    }

    public static void kq(boolean z) {
        eUV = z;
    }

    public static void aYj() {
        eUW = com.baidu.adp.lib.b.e.eY().Y("android_video_cache_open") == 1;
    }
}
