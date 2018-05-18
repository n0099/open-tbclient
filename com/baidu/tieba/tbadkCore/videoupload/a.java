package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int gAd = 6144000;
    private static int gAe = 524288;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gAf;
    private h gyx;

    public a(h hVar) {
        this.gyx = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eE().ak("is_video_batch") == 1) {
                this.gAf = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gAe, this.gyx);
            } else {
                this.gAf = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gAd, this.gyx);
            }
            this.gAf.a(eVar);
            return this.gAf.aL(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gyx != null) {
                this.gyx.e(306, -4399, com.baidu.tieba.j.a.g(e));
            }
            return null;
        }
    }

    public void bsW() {
        if (this.gAf != null) {
            this.gAf.cancel();
        }
    }

    public static void tx(int i) {
        if (i <= 0) {
            gAe = 524288;
        } else {
            gAe = i;
        }
    }

    public static void ty(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void tz(int i) {
        if (i <= 0) {
            gAd = 6144000;
        } else {
            gAd = i;
        }
    }
}
