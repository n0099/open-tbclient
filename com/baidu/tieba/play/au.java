package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class au {
    private static x fbX = null;
    private static boolean fbY = true;
    private static boolean fbZ = true;

    private static x aXZ() {
        if (fbX == null) {
            fbY = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, x.class);
            if (runTask != null) {
                fbX = (x) runTask.getData();
            }
        }
        return fbX;
    }

    public static String gP(String str) {
        if (fbZ && fbY && aXZ() != null) {
            return aXZ().gP(str);
        }
        return str;
    }

    public static String gQ(String str) {
        if (aXZ() != null) {
            return aXZ().gQ(str);
        }
        return null;
    }

    public static void ae(Context context, String str) {
        if (aXZ() != null) {
            aXZ().ae(context, str);
        }
    }

    public static void af(Context context, String str) {
        if (fbZ && fbY && aXZ() != null) {
            aXZ().af(context, str);
        }
    }

    public static void gR(String str) {
        if (fbZ && fbY && aXZ() != null) {
            aXZ().gR(str);
        }
    }

    public static void aY(Context context) {
        if (aXZ() != null) {
            aXZ().aY(context);
        }
    }

    public static void kB(boolean z) {
        fbY = z;
    }

    public static void aYa() {
        fbZ = com.baidu.adp.lib.b.e.eZ().Y("android_video_cache_open") == 1;
    }
}
