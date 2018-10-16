package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hfJ = 6144000;
    private static int hfK = 524288;
    private h hea;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hfL;

    public a(h hVar) {
        this.hea = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iR().aO("is_video_batch") == 1) {
                this.hfL = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hfK, this.hea);
            } else {
                this.hfL = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hfJ, this.hea);
            }
            this.hfL.a(eVar);
            return this.hfL.aU(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hea != null) {
                this.hea.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void qJ() {
        if (this.hfL != null) {
            this.hfL.cancel();
        }
    }

    public static void uQ(int i) {
        if (i <= 0) {
            hfK = 524288;
        } else {
            hfK = i;
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
            hfJ = 6144000;
        } else {
            hfJ = i;
        }
    }
}
