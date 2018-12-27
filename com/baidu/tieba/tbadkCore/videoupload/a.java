package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hro = 6144000;
    private static int hrp = 524288;
    private h hpD;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hrq;

    public a(h hVar) {
        this.hpD = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.hrq = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hrp, this.hpD);
            } else {
                this.hrq = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hro, this.hpD);
            }
            this.hrq.a(eVar);
            return this.hrq.aW(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hpD != null) {
                this.hpD.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void qG() {
        if (this.hrq != null) {
            this.hrq.cancel();
        }
    }

    public static void vS(int i) {
        if (i <= 0) {
            hrp = 524288;
        } else {
            hrp = i;
        }
    }

    public static void vT(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vU(int i) {
        if (i <= 0) {
            hro = 6144000;
        } else {
            hro = i;
        }
    }
}
