package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hlr = 6144000;
    private static int hls = 524288;
    private h hjJ;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hlt;

    public a(h hVar) {
        this.hjJ = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.mz().an("is_video_batch") == 1) {
                this.hlt = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hls, this.hjJ);
            } else {
                this.hlt = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hlr, this.hjJ);
            }
            this.hlt.a(eVar);
            return this.hlt.aH(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hjJ != null) {
                this.hjJ.h(306, -4399, com.baidu.tieba.i.a.i(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.hlt != null) {
            this.hlt.cancel();
        }
    }

    public static void xs(int i) {
        if (i <= 0) {
            hls = 524288;
        } else {
            hls = i;
        }
    }

    public static void xt(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void xu(int i) {
        if (i <= 0) {
            hlr = 6144000;
        } else {
            hlr = i;
        }
    }
}
