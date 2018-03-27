package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hdJ = 6144000;
    private static int hdK = 524288;
    private h hca;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hdL;

    public a(h hVar) {
        this.hca = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.mA().an("is_video_batch") == 1) {
                this.hdL = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hdK, this.hca);
            } else {
                this.hdL = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hdJ, this.hca);
            }
            this.hdL.a(eVar);
            return this.hdL.aK(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hca != null) {
                this.hca.h(306, -4399, com.baidu.tieba.i.a.i(e));
            }
            return null;
        }
    }

    public void bxY() {
        if (this.hdL != null) {
            this.hdL.cancel();
        }
    }

    public static void vW(int i) {
        if (i <= 0) {
            hdK = 524288;
        } else {
            hdK = i;
        }
    }

    public static void vX(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vY(int i) {
        if (i <= 0) {
            hdJ = 6144000;
        } else {
            hdJ = i;
        }
    }
}
