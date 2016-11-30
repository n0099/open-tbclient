package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fEN = 6144000;
    private static int fEO = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fEP;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.c.e.dN().ac("is_video_batch") == 1) {
                this.fEP = new d(str2, fEO);
            } else {
                this.fEP = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fEN);
            }
            this.fEP.a(eVar);
            return this.fEP.aG(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bnh() {
        if (this.fEP != null) {
            this.fEP.cancel();
        }
    }

    public static void sq(int i) {
        if (i <= 0) {
            fEO = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fEO = i;
        }
    }

    public static void sr(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void ss(int i) {
        if (i <= 0) {
            fEN = 6144000;
        } else {
            fEN = i;
        }
    }
}
