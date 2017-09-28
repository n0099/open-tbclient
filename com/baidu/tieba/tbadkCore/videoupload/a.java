package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gjt = 6144000;
    private static int gju = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gjv;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eV().af("is_video_batch") == 1) {
                this.gjv = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gju);
            } else {
                this.gjv = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gjt);
            }
            this.gjv.a(eVar);
            return this.gjv.az(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bsx() {
        if (this.gjv != null) {
            this.gjv.cancel();
        }
    }

    public static void tK(int i) {
        if (i <= 0) {
            gju = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gju = i;
        }
    }

    public static void tL(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void tM(int i) {
        if (i <= 0) {
            gjt = 6144000;
        } else {
            gjt = i;
        }
    }
}
