package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fwD = 6144000;
    private static int fwE = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fwF;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.b.e.eT().ab("is_video_batch") == 1) {
                this.fwF = new d(str2, fwE);
            } else {
                this.fwF = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fwD);
            }
            this.fwF.a(eVar);
            return this.fwF.aw(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void biC() {
        if (this.fwF != null) {
            this.fwF.cancel();
        }
    }

    public static void sd(int i) {
        if (i <= 0) {
            fwE = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fwE = i;
        }
    }

    public static void se(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void sf(int i) {
        if (i <= 0) {
            fwD = 6144000;
        } else {
            fwD = i;
        }
    }
}
