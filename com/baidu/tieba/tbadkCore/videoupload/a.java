package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hbm = 6144000;
    private static int hbn = 524288;
    private h gZD;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hbo;

    public a(h hVar) {
        this.gZD = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.mA().an("is_video_batch") == 1) {
                this.hbo = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hbn, this.gZD);
            } else {
                this.hbo = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hbm, this.gZD);
            }
            this.hbo.a(eVar);
            return this.hbo.aJ(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gZD != null) {
                this.gZD.h(306, -4399, com.baidu.tieba.i.a.i(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.hbo != null) {
            this.hbo.cancel();
        }
    }

    public static void vU(int i) {
        if (i <= 0) {
            hbn = 524288;
        } else {
            hbn = i;
        }
    }

    public static void vV(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vW(int i) {
        if (i <= 0) {
            hbm = 6144000;
        } else {
            hbm = i;
        }
    }
}
