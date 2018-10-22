package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hfK = 6144000;
    private static int hfL = 524288;
    private h heb;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hfM;

    public a(h hVar) {
        this.heb = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iR().aO("is_video_batch") == 1) {
                this.hfM = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hfL, this.heb);
            } else {
                this.hfM = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hfK, this.heb);
            }
            this.hfM.a(eVar);
            return this.hfM.aU(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.heb != null) {
                this.heb.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void qJ() {
        if (this.hfM != null) {
            this.hfM.cancel();
        }
    }

    public static void uQ(int i) {
        if (i <= 0) {
            hfL = 524288;
        } else {
            hfL = i;
        }
    }

    public static void uR(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void uS(int i) {
        if (i <= 0) {
            hfK = 6144000;
        } else {
            hfK = i;
        }
    }
}
