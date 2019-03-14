package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int iIW = 6144000;
    private static int iIX = 524288;
    private h iHn;
    private com.baidu.tieba.tbadkCore.videoupload.a.b iIY;

    public a(h hVar) {
        this.iHn = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.iIY = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, iIX, this.iHn);
            } else {
                this.iIY = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, iIW, this.iHn);
            }
            this.iIY.a(eVar);
            return this.iIY.bs(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.iHn != null) {
                this.iHn.g(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cfx() {
        if (this.iIY != null) {
            this.iIY.cancel();
        }
    }

    public static void zE(int i) {
        if (i <= 0) {
            iIX = 524288;
        } else {
            iIX = i;
        }
    }

    public static void zF(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void zG(int i) {
        if (i <= 0) {
            iIW = 6144000;
        } else {
            iIW = i;
        }
    }
}
