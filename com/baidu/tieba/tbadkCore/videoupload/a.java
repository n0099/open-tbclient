package com.baidu.tieba.tbadkCore.videoupload;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private static int fyn = 6144000;
    private static int fyo = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
    private com.baidu.tieba.tbadkCore.videoupload.a.b fyp;

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (com.baidu.adp.lib.b.e.eY().Y("is_video_batch") == 1) {
                this.fyp = new d(str2, fyo);
            } else {
                this.fyp = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, fyn);
            }
            this.fyp.a(eVar);
            return this.fyp.aw(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void bjn() {
        if (this.fyp != null) {
            this.fyp.cancel();
        }
    }

    public static void sb(int i) {
        if (i <= 0) {
            fyo = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            fyo = i;
        }
    }

    public static void sc(int i) {
        if (i <= 0) {
            chunkLength = AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        } else {
            chunkLength = i;
        }
    }

    public static void sd(int i) {
        if (i <= 0) {
            fyn = 6144000;
        } else {
            fyn = i;
        }
    }
}
