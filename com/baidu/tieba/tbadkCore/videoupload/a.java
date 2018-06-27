package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int gPG = 6144000;
    private static int gPH = 524288;
    private h gOa;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gPI;

    public a(h hVar) {
        this.gOa = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hv().aw("is_video_batch") == 1) {
                this.gPI = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gPH, this.gOa);
            } else {
                this.gPI = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gPG, this.gOa);
            }
            this.gPI.a(eVar);
            return this.gPI.aP(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gOa != null) {
                this.gOa.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.m(e));
            }
            return null;
        }
    }

    public void byF() {
        if (this.gPI != null) {
            this.gPI.cancel();
        }
    }

    public static void tV(int i) {
        if (i <= 0) {
            gPH = 524288;
        } else {
            gPH = i;
        }
    }

    public static void tW(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void tX(int i) {
        if (i <= 0) {
            gPG = 6144000;
        } else {
            gPG = i;
        }
    }
}
