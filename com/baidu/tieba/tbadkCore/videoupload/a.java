package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gBO = 6144000;
    private static int gBP = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private h gAg;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gBQ;

    public a(h hVar) {
        this.gAg = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eV().af("is_video_batch") == 1) {
                this.gBQ = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gBP, this.gAg);
            } else {
                this.gBQ = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gBO, this.gAg);
            }
            this.gBQ.a(eVar);
            return this.gBQ.aG(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gAg != null) {
                this.gAg.f(306, -4399, com.baidu.tieba.i.a.g(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.gBQ != null) {
            this.gBQ.cancel();
        }
    }

    public static void uu(int i) {
        if (i <= 0) {
            gBP = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gBP = i;
        }
    }

    public static void uv(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void uw(int i) {
        if (i <= 0) {
            gBO = 6144000;
        } else {
            gBO = i;
        }
    }
}
