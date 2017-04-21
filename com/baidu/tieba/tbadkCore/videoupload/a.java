package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fAD = 6144000;
    private static int fAE = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fAF;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.b.e.eZ().Y("is_video_batch") == 1) {
                this.fAF = new d(str2, fAE);
            } else {
                this.fAF = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fAD);
            }
            this.fAF.a(eVar);
            return this.fAF.aw(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bko() {
        if (this.fAF != null) {
            this.fAF.cancel();
        }
    }

    public static void sh(int i) {
        if (i <= 0) {
            fAE = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fAE = i;
        }
    }

    public static void si(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void sj(int i) {
        if (i <= 0) {
            fAD = 6144000;
        } else {
            fAD = i;
        }
    }
}
