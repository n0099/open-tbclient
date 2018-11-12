package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hhi = 6144000;
    private static int hhj = 524288;
    private h hfy;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hhk;

    public a(h hVar) {
        this.hfy = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.hhk = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hhj, this.hfy);
            } else {
                this.hhk = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hhi, this.hfy);
            }
            this.hhk.a(eVar);
            return this.hhk.aU(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hfy != null) {
                this.hfy.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void qH() {
        if (this.hhk != null) {
            this.hhk.cancel();
        }
    }

    public static void vj(int i) {
        if (i <= 0) {
            hhj = 524288;
        } else {
            hhj = i;
        }
    }

    public static void vk(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vl(int i) {
        if (i <= 0) {
            hhi = 6144000;
        } else {
            hhi = i;
        }
    }
}
