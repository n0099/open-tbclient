package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int gzd = 6144000;
    private static int gze = 524288;
    private h gxw;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gzf;

    public a(h hVar) {
        this.gxw = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.eE().ak("is_video_batch") == 1) {
                this.gzf = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gze, this.gxw);
            } else {
                this.gzf = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gzd, this.gxw);
            }
            this.gzf.a(eVar);
            return this.gzf.aL(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gxw != null) {
                this.gxw.e(306, -4399, com.baidu.tieba.j.a.g(e));
            }
            return null;
        }
    }

    public void bsY() {
        if (this.gzf != null) {
            this.gzf.cancel();
        }
    }

    public static void ty(int i) {
        if (i <= 0) {
            gze = 524288;
        } else {
            gze = i;
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
            gzd = 6144000;
        } else {
            gzd = i;
        }
    }
}
