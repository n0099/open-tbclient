package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fEE = 6144000;
    private static int fEF = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fEG;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.b.e.eZ().Y("is_video_batch") == 1) {
                this.fEG = new d(str2, fEF);
            } else {
                this.fEG = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fEE);
            }
            this.fEG.a(eVar);
            return this.fEG.ax(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bjf() {
        if (this.fEG != null) {
            this.fEG.cancel();
        }
    }

    public static void sv(int i) {
        if (i <= 0) {
            fEF = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fEF = i;
        }
    }

    public static void sw(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void sx(int i) {
        if (i <= 0) {
            fEE = 6144000;
        } else {
            fEE = i;
        }
    }
}
