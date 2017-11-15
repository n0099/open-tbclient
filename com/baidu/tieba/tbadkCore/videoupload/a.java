package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int gsS = 6144000;
    private static int gsT = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gsU;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eV().af("is_video_batch") == 1) {
                this.gsU = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gsT);
            } else {
                this.gsU = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gsS);
            }
            this.gsU.a(eVar);
            return this.gsU.aF(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void cancelUpload() {
        if (this.gsU != null) {
            this.gsU.cancel();
        }
    }

    public static void ue(int i) {
        if (i <= 0) {
            gsT = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            gsT = i;
        }
    }

    public static void uf(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void ug(int i) {
        if (i <= 0) {
            gsS = 6144000;
        } else {
            gsS = i;
        }
    }
}
