package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int jbB = 6144000;
    private static int jbC = 524288;
    private h iZR;
    private com.baidu.tieba.tbadkCore.videoupload.a.b jbD;

    public a(h hVar) {
        this.iZR = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hI().ay("is_video_batch") == 1) {
                this.jbD = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, jbC, this.iZR);
            } else {
                this.jbD = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, jbB, this.iZR);
            }
            this.jbD.a(eVar);
            return this.jbD.bo(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.iZR != null) {
                this.iZR.h(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cnx() {
        if (this.jbD != null) {
            this.jbD.cancel();
        }
    }

    public static void AI(int i) {
        if (i <= 0) {
            jbC = 524288;
        } else {
            jbC = i;
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
            jbB = 6144000;
        } else {
            jbB = i;
        }
    }
}
