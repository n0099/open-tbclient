package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int grP = 6144000;
    private static int grQ = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b grR;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eV().af("is_video_batch") == 1) {
                this.grR = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, grQ);
            } else {
                this.grR = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, grP);
            }
            this.grR.a(eVar);
            return this.grR.aF(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void cancelUpload() {
        if (this.grR != null) {
            this.grR.cancel();
        }
    }

    public static void ua(int i) {
        if (i <= 0) {
            grQ = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            grQ = i;
        }
    }

    public static void ub(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void uc(int i) {
        if (i <= 0) {
            grP = 6144000;
        } else {
            grP = i;
        }
    }
}
