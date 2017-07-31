package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gkt = 6144000;
    private static int gku = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gkv;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.fh().al("is_video_batch") == 1) {
                this.gkv = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gku);
            } else {
                this.gkv = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gkt);
            }
            this.gkv.a(eVar);
            return this.gkv.aA(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void btx() {
        if (this.gkv != null) {
            this.gkv.cancel();
        }
    }

    public static void tr(int i) {
        if (i <= 0) {
            gku = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gku = i;
        }
    }

    public static void ts(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void tt(int i) {
        if (i <= 0) {
            gkt = 6144000;
        } else {
            gkt = i;
        }
    }
}
