package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gml = 6144000;
    private static int gmm = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gmn;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.fh().am("is_video_batch") == 1) {
                this.gmn = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gmm);
            } else {
                this.gmn = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gml);
            }
            this.gmn.a(eVar);
            return this.gmn.aA(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void btY() {
        if (this.gmn != null) {
            this.gmn.cancel();
        }
    }

    public static void tB(int i) {
        if (i <= 0) {
            gmm = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gmm = i;
        }
    }

    public static void tC(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void tD(int i) {
        if (i <= 0) {
            gml = 6144000;
        } else {
            gml = i;
        }
    }
}
