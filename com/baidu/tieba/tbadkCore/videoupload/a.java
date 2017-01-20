package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fsg = 6144000;
    private static int fsh = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fsi;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.b.e.dL().ac("is_video_batch") == 1) {
                this.fsi = new d(str2, fsh);
            } else {
                this.fsi = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fsg);
            }
            this.fsi.a(eVar);
            return this.fsi.aD(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void biM() {
        if (this.fsi != null) {
            this.fsi.cancel();
        }
    }

    public static void se(int i) {
        if (i <= 0) {
            fsh = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fsh = i;
        }
    }

    public static void sf(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void sg(int i) {
        if (i <= 0) {
            fsg = 6144000;
        } else {
            fsg = i;
        }
    }
}
