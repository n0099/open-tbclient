package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int gLE = 6144000;
    private static int gLF = 524288;
    private h gJZ;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gLG;

    public a(h hVar) {
        this.gJZ = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hv().aw("is_video_batch") == 1) {
                this.gLG = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gLF, this.gJZ);
            } else {
                this.gLG = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gLE, this.gJZ);
            }
            this.gLG.a(eVar);
            return this.gLG.aO(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gJZ != null) {
                this.gJZ.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.m(e));
            }
            return null;
        }
    }

    public void byb() {
        if (this.gLG != null) {
            this.gLG.cancel();
        }
    }

    public static void tJ(int i) {
        if (i <= 0) {
            gLF = 524288;
        } else {
            gLF = i;
        }
    }

    public static void tK(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void tL(int i) {
        if (i <= 0) {
            gLE = 6144000;
        } else {
            gLE = i;
        }
    }
}
