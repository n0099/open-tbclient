package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gkN = 6144000;
    private static int gkO = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gkP;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eW().af("is_video_batch") == 1) {
                this.gkP = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gkO);
            } else {
                this.gkP = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gkN);
            }
            this.gkP.a(eVar);
            return this.gkP.aA(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void btn() {
        if (this.gkP != null) {
            this.gkP.cancel();
        }
    }

    public static void tD(int i) {
        if (i <= 0) {
            gkO = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gkO = i;
        }
    }

    public static void tE(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void tF(int i) {
        if (i <= 0) {
            gkN = 6144000;
        } else {
            gkN = i;
        }
    }
}
