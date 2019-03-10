package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int iJe = 6144000;
    private static int iJf = 524288;
    private h iHv;
    private com.baidu.tieba.tbadkCore.videoupload.a.b iJg;

    public a(h hVar) {
        this.iHv = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.iJg = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, iJf, this.iHv);
            } else {
                this.iJg = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, iJe, this.iHv);
            }
            this.iJg.a(eVar);
            return this.iJg.bs(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.iHv != null) {
                this.iHv.g(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cfv() {
        if (this.iJg != null) {
            this.iJg.cancel();
        }
    }

    public static void zE(int i) {
        if (i <= 0) {
            iJf = 524288;
        } else {
            iJf = i;
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
            iJe = 6144000;
        } else {
            iJe = i;
        }
    }
}
