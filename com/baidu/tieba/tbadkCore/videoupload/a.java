package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int iJd = 6144000;
    private static int iJe = 524288;
    private h iHu;
    private com.baidu.tieba.tbadkCore.videoupload.a.b iJf;

    public a(h hVar) {
        this.iHu = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.iJf = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, iJe, this.iHu);
            } else {
                this.iJf = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, iJd, this.iHu);
            }
            this.iJf.a(eVar);
            return this.iJf.bs(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.iHu != null) {
                this.iHu.g(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cfu() {
        if (this.iJf != null) {
            this.iJf.cancel();
        }
    }

    public static void zE(int i) {
        if (i <= 0) {
            iJe = 524288;
        } else {
            iJe = i;
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
            iJd = 6144000;
        } else {
            iJd = i;
        }
    }
}
