package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gEy = 6144000;
    private static int gEz = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private h gCP;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gEA;

    public a(h hVar) {
        this.gCP = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eV().af("is_video_batch") == 1) {
                this.gEA = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gEz, this.gCP);
            } else {
                this.gEA = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gEy, this.gCP);
            }
            this.gEA.a(eVar);
            return this.gEA.aH(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gCP != null) {
                this.gCP.f(306, -4399, com.baidu.tieba.i.a.g(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.gEA != null) {
            this.gEA.cancel();
        }
    }

    public static void uF(int i) {
        if (i <= 0) {
            gEz = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gEz = i;
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
            gEy = 6144000;
        } else {
            gEy = i;
        }
    }
}
