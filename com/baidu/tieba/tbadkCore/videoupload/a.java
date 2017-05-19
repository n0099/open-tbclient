package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fwM = 6144000;
    private static int fwN = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fwO;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.b.e.eZ().Y("is_video_batch") == 1) {
                this.fwO = new d(str2, fwN);
            } else {
                this.fwO = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fwM);
            }
            this.fwO.a(eVar);
            return this.fwO.ay(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bhL() {
        if (this.fwO != null) {
            this.fwO.cancel();
        }
    }

    public static void rZ(int i) {
        if (i <= 0) {
            fwN = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fwN = i;
        }
    }

    public static void sa(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void sb(int i) {
        if (i <= 0) {
            fwM = 6144000;
        } else {
            fwM = i;
        }
    }
}
