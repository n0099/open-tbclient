package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gji = 6144000;
    private static int gjj = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gjk;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eW().af("is_video_batch") == 1) {
                this.gjk = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gjj);
            } else {
                this.gjk = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gji);
            }
            this.gjk.a(eVar);
            return this.gjk.aA(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void btq() {
        if (this.gjk != null) {
            this.gjk.cancel();
        }
    }

    public static void ts(int i) {
        if (i <= 0) {
            gjj = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gjj = i;
        }
    }

    public static void tt(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void tu(int i) {
        if (i <= 0) {
            gji = 6144000;
        } else {
            gji = i;
        }
    }
}
