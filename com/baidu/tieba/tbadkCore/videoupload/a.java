package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int jlB = 524288;
    private static int jlC = 6144000;
    private static int jlD = 524288;
    private h jjR;
    private com.baidu.tieba.tbadkCore.videoupload.a.b jlE;

    public a(h hVar) {
        this.jjR = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hS().az("is_video_batch") == 1) {
                this.jlE = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, jlD, this.jjR);
            } else {
                this.jlE = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, jlB, jlC, this.jjR);
            }
            this.jlE.a(eVar);
            return this.jlE.br(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.jjR != null) {
                this.jjR.h(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void crD() {
        if (this.jlE != null) {
            this.jlE.cancel();
        }
    }

    public static void Bu(int i) {
        if (i <= 0) {
            jlD = 524288;
        } else {
            jlD = i;
        }
    }

    public static void Bv(int i) {
        if (i <= 0) {
            jlB = 524288;
        } else {
            jlB = i;
        }
    }

    public static void Bw(int i) {
        if (i <= 0) {
            jlC = 6144000;
        } else {
            jlC = i;
        }
    }
}
