package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int iIH = 6144000;
    private static int iII = 524288;
    private h iGX;
    private com.baidu.tieba.tbadkCore.videoupload.a.b iIJ;

    public a(h hVar) {
        this.iGX = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.iIJ = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, iII, this.iGX);
            } else {
                this.iIJ = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, iIH, this.iGX);
            }
            this.iIJ.a(eVar);
            return this.iIJ.bs(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.iGX != null) {
                this.iGX.g(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cft() {
        if (this.iIJ != null) {
            this.iIJ.cancel();
        }
    }

    public static void zA(int i) {
        if (i <= 0) {
            iII = 524288;
        } else {
            iII = i;
        }
    }

    public static void zB(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void zC(int i) {
        if (i <= 0) {
            iIH = 6144000;
        } else {
            iIH = i;
        }
    }
}
