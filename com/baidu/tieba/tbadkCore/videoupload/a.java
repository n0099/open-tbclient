package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int jbH = 6144000;
    private static int jbI = 524288;
    private h iZX;
    private com.baidu.tieba.tbadkCore.videoupload.a.b jbJ;

    public a(h hVar) {
        this.iZX = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hI().ay("is_video_batch") == 1) {
                this.jbJ = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, jbI, this.iZX);
            } else {
                this.jbJ = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, jbH, this.iZX);
            }
            this.jbJ.a(eVar);
            return this.jbJ.bo(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.iZX != null) {
                this.iZX.h(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cnA() {
        if (this.jbJ != null) {
            this.jbJ.cancel();
        }
    }

    public static void AI(int i) {
        if (i <= 0) {
            jbI = 524288;
        } else {
            jbI = i;
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
            jbH = 6144000;
        } else {
            jbH = i;
        }
    }
}
