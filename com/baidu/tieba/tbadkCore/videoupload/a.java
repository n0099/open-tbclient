package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int gza = 6144000;
    private static int gzb = 524288;
    private h gxt;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gzc;

    public a(h hVar) {
        this.gxt = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eE().ak("is_video_batch") == 1) {
                this.gzc = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gzb, this.gxt);
            } else {
                this.gzc = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gza, this.gxt);
            }
            this.gzc.a(eVar);
            return this.gzc.aL(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gxt != null) {
                this.gxt.e(306, -4399, com.baidu.tieba.j.a.g(e));
            }
            return null;
        }
    }

    public void bsY() {
        if (this.gzc != null) {
            this.gzc.cancel();
        }
    }

    public static void ty(int i) {
        if (i <= 0) {
            gzb = 524288;
        } else {
            gzb = i;
        }
    }

    public static void tz(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void tA(int i) {
        if (i <= 0) {
            gza = 6144000;
        } else {
            gza = i;
        }
    }
}
