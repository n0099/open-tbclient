package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int jbD = 6144000;
    private static int jbE = 524288;
    private h iZT;
    private com.baidu.tieba.tbadkCore.videoupload.a.b jbF;

    public a(h hVar) {
        this.iZT = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hI().ay("is_video_batch") == 1) {
                this.jbF = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, jbE, this.iZT);
            } else {
                this.jbF = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, jbD, this.iZT);
            }
            this.jbF.a(eVar);
            return this.jbF.bo(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.iZT != null) {
                this.iZT.h(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cnz() {
        if (this.jbF != null) {
            this.jbF.cancel();
        }
    }

    public static void AI(int i) {
        if (i <= 0) {
            jbE = 524288;
        } else {
            jbE = i;
        }
    }

    public static void AJ(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void AK(int i) {
        if (i <= 0) {
            jbD = 6144000;
        } else {
            jbD = i;
        }
    }
}
