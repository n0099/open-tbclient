package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int glH = 6144000;
    private static int glI = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b glJ;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eW().af("is_video_batch") == 1) {
                this.glJ = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, glI);
            } else {
                this.glJ = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, glH);
            }
            this.glJ.a(eVar);
            return this.glJ.aA(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bty() {
        if (this.glJ != null) {
            this.glJ.cancel();
        }
    }

    public static void tF(int i) {
        if (i <= 0) {
            glI = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            glI = i;
        }
    }

    public static void tG(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void tH(int i) {
        if (i <= 0) {
            glH = 6144000;
        } else {
            glH = i;
        }
    }
}
