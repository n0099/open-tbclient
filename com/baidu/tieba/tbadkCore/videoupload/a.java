package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int gQF = 6144000;
    private static int gQG = 524288;
    private h gPa;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gQH;

    public a(h hVar) {
        this.gPa = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hv().ax("is_video_batch") == 1) {
                this.gQH = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gQG, this.gPa);
            } else {
                this.gQH = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gQF, this.gPa);
            }
            this.gQH.a(eVar);
            return this.gQH.aL(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gPa != null) {
                this.gPa.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.m(e));
            }
            return null;
        }
    }

    public void bxj() {
        if (this.gQH != null) {
            this.gQH.cancel();
        }
    }

    public static void tT(int i) {
        if (i <= 0) {
            gQG = 524288;
        } else {
            gQG = i;
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
            gQF = 6144000;
        } else {
            gQF = i;
        }
    }
}
