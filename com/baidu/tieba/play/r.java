package com.baidu.tieba.play;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r {
    private static h fCh = null;
    private static boolean fCi = true;
    private static boolean fCj = true;

    private static h bgB() {
        if (fCh == null) {
            fCi = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, h.class);
            if (runTask != null) {
                fCh = (h) runTask.getData();
            }
        }
        return fCh;
    }

    public static String hx(String str) {
        if (fCj && fCi && bgB() != null) {
            return bgB().hx(str);
        }
        return str;
    }

    public static String hy(String str) {
        if (bgB() != null) {
            return bgB().hy(str);
        }
        return null;
    }

    public static void af(Context context, String str) {
        if (bgB() != null) {
            bgB().af(context, str);
        }
    }

    public static void ag(Context context, String str) {
        if (fCj && fCi && bgB() != null) {
            bgB().ag(context, str);
        }
    }

    public static void hz(String str) {
        if (fCj && fCi && bgB() != null) {
            bgB().hz(str);
        }
    }

    public static void aZ(Context context) {
        if (bgB() != null) {
            bgB().aZ(context);
        }
    }

    public static void lz(boolean z) {
        fCi = z;
    }

    public static void bgC() {
        fCj = com.baidu.adp.lib.b.d.fh().al("android_video_cache_open") == 1;
    }
}
