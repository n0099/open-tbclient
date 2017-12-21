package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gED = 6144000;
    private static int gEE = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private h gCU;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gEF;

    public a(h hVar) {
        this.gCU = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eV().af("is_video_batch") == 1) {
                this.gEF = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gEE, this.gCU);
            } else {
                this.gEF = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gED, this.gCU);
            }
            this.gEF.a(eVar);
            return this.gEF.aH(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gCU != null) {
                this.gCU.f(306, -4399, com.baidu.tieba.i.a.g(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.gEF != null) {
            this.gEF.cancel();
        }
    }

    public static void uF(int i) {
        if (i <= 0) {
            gEE = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gEE = i;
        }
    }

    public static void uG(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void uH(int i) {
        if (i <= 0) {
            gED = 6144000;
        } else {
            gED = i;
        }
    }
}
