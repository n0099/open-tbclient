package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int jlr = 524288;
    private static int jls = 6144000;
    private static int jlt = 524288;
    private h jjG;
    private com.baidu.tieba.tbadkCore.videoupload.a.b jlu;

    public a(h hVar) {
        this.jjG = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.ft().af("is_video_batch") == 1) {
                this.jlu = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, jlt, this.jjG);
            } else {
                this.jlu = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, jlr, jls, this.jjG);
            }
            this.jlu.a(eVar);
            return this.jlu.bm(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.jjG != null) {
                this.jjG.h(306, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void cpw() {
        if (this.jlu != null) {
            this.jlu.cancel();
        }
    }

    public static void Ad(int i) {
        if (i <= 0) {
            jlt = 524288;
        } else {
            jlt = i;
        }
    }

    public static void Ae(int i) {
        if (i <= 0) {
            jlr = 524288;
        } else {
            jlr = i;
        }
    }

    public static void Af(int i) {
        if (i <= 0) {
            jls = 6144000;
        } else {
            jls = i;
        }
    }
}
