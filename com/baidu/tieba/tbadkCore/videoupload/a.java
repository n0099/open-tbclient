package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gje = 6144000;
    private static int gjf = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gjg;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eV().af("is_video_batch") == 1) {
                this.gjg = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gjf);
            } else {
                this.gjg = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gje);
            }
            this.gjg.a(eVar);
            return this.gjg.az(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void cancelUpload() {
        if (this.gjg != null) {
            this.gjg.cancel();
        }
    }

    public static void tJ(int i) {
        if (i <= 0) {
            gjf = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gjf = i;
        }
    }

    public static void tK(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void tL(int i) {
        if (i <= 0) {
            gje = 6144000;
        } else {
            gje = i;
        }
    }
}
