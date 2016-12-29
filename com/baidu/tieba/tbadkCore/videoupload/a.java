package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fiU = 6144000;
    private static int fiV = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fiW;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.c.e.dN().ac("is_video_batch") == 1) {
                this.fiW = new d(str2, fiV);
            } else {
                this.fiW = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fiU);
            }
            this.fiW.a(eVar);
            return this.fiW.aC(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bhb() {
        if (this.fiW != null) {
            this.fiW.cancel();
        }
    }

    public static void rt(int i) {
        if (i <= 0) {
            fiV = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fiV = i;
        }
    }

    public static void ru(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void rv(int i) {
        if (i <= 0) {
            fiU = 6144000;
        } else {
            fiU = i;
        }
    }
}
