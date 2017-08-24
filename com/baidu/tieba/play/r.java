package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r {
    private static h fCj = null;
    private static boolean fCk = true;
    private static boolean fCl = true;

    private static h bgw() {
        if (fCj == null) {
            fCk = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, h.class);
            if (runTask != null) {
                fCj = (h) runTask.getData();
            }
        }
        return fCj;
    }

    public static String hA(String str) {
        if (fCl && fCk && bgw() != null) {
            return bgw().hA(str);
        }
        return str;
    }

    public static String hB(String str) {
        if (bgw() != null) {
            return bgw().hB(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (bgw() != null) {
            bgw().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fCl && fCk && bgw() != null) {
            bgw().ag(context, str);
        }
    }

    public static void hC(String str) {
        if (fCl && fCk && bgw() != null) {
            bgw().hC(str);
        }
    }

    public static void aZ(Context context) {
        if (bgw() != null) {
            bgw().aZ(context);
        }
    }

    public static void lz(boolean z) {
        fCk = z;
    }

    public static void bgx() {
        fCl = com.baidu.adp.lib.b.d.fh().am("android_video_cache_open") == 1;
    }
}
