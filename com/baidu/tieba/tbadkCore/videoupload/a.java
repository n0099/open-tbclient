package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gjs = 6144000;
    private static int gjt = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gju;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eV().af("is_video_batch") == 1) {
                this.gju = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gjt);
            } else {
                this.gju = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gjs);
            }
            this.gju.a(eVar);
            return this.gju.az(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bsw() {
        if (this.gju != null) {
            this.gju.cancel();
        }
    }

    public static void tK(int i) {
        if (i <= 0) {
            gjt = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gjt = i;
        }
    }

    public static void tL(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void tM(int i) {
        if (i <= 0) {
            gjs = 6144000;
        } else {
            gjs = i;
        }
    }
}
