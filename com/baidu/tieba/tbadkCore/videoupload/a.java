package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int iII = 6144000;
    private static int iIJ = 524288;
    private h iGY;
    private com.baidu.tieba.tbadkCore.videoupload.a.b iIK;

    public a(h hVar) {
        this.iGY = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.iIK = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, iIJ, this.iGY);
            } else {
                this.iIK = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, iII, this.iGY);
            }
            this.iIK.a(eVar);
            return this.iIK.bs(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.iGY != null) {
                this.iGY.g(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cft() {
        if (this.iIK != null) {
            this.iIK.cancel();
        }
    }

    public static void zA(int i) {
        if (i <= 0) {
            iIJ = 524288;
        } else {
            iIJ = i;
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
            iII = 6144000;
        } else {
            iII = i;
        }
    }
}
