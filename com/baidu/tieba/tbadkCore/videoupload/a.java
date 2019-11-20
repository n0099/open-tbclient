package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int jkA = 524288;
    private static int jkB = 6144000;
    private static int jkC = 524288;
    private h jiP;
    private com.baidu.tieba.tbadkCore.videoupload.a.b jkD;

    public a(h hVar) {
        this.jiP = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.ft().af("is_video_batch") == 1) {
                this.jkD = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, jkC, this.jiP);
            } else {
                this.jkD = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, jkA, jkB, this.jiP);
            }
            this.jkD.a(eVar);
            return this.jkD.bm(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.jiP != null) {
                this.jiP.h(306, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void cpu() {
        if (this.jkD != null) {
            this.jkD.cancel();
        }
    }

    public static void Ac(int i) {
        if (i <= 0) {
            jkC = 524288;
        } else {
            jkC = i;
        }
    }

    public static void Ad(int i) {
        if (i <= 0) {
            jkA = 524288;
        } else {
            jkA = i;
        }
    }

    public static void Ae(int i) {
        if (i <= 0) {
            jkB = 6144000;
        } else {
            jkB = i;
        }
    }
}
