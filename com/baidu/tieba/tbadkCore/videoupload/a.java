package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hdA = 6144000;
    private static int hdB = 524288;
    private h hbR;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hdC;

    public a(h hVar) {
        this.hbR = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.mA().an("is_video_batch") == 1) {
                this.hdC = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hdB, this.hbR);
            } else {
                this.hdC = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hdA, this.hbR);
            }
            this.hdC.a(eVar);
            return this.hdC.aK(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hbR != null) {
                this.hbR.h(306, -4399, com.baidu.tieba.i.a.i(e));
            }
            return null;
        }
    }

    public void bxU() {
        if (this.hdC != null) {
            this.hdC.cancel();
        }
    }

    public static void vV(int i) {
        if (i <= 0) {
            hdB = 524288;
        } else {
            hdB = i;
        }
    }

    public static void vW(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vX(int i) {
        if (i <= 0) {
            hdA = 6144000;
        } else {
            hdA = i;
        }
    }
}
