package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int gQE = 6144000;
    private static int gQF = 524288;
    private h gOY;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gQG;

    public a(h hVar) {
        this.gOY = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hv().ax("is_video_batch") == 1) {
                this.gQG = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gQF, this.gOY);
            } else {
                this.gQG = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gQE, this.gOY);
            }
            this.gQG.a(eVar);
            return this.gQG.aL(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gOY != null) {
                this.gOY.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.m(e));
            }
            return null;
        }
    }

    public void bxi() {
        if (this.gQG != null) {
            this.gQG.cancel();
        }
    }

    public static void tT(int i) {
        if (i <= 0) {
            gQF = 524288;
        } else {
            gQF = i;
        }
    }

    public static void tU(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void tV(int i) {
        if (i <= 0) {
            gQE = 6144000;
        } else {
            gQE = i;
        }
    }
}
