package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fOJ = 6144000;
    private static int fOK = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fOL;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.b.e.eY().ad("is_video_batch") == 1) {
                this.fOL = new d(str2, fOK);
            } else {
                this.fOL = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fOJ);
            }
            this.fOL.a(eVar);
            return this.fOL.ay(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bnt() {
        if (this.fOL != null) {
            this.fOL.cancel();
        }
    }

    public static void sO(int i) {
        if (i <= 0) {
            fOK = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fOK = i;
        }
    }

    public static void sP(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void sQ(int i) {
        if (i <= 0) {
            fOJ = 6144000;
        } else {
            fOJ = i;
        }
    }
}
