package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int jjg = 524288;
    private static int jjh = 6144000;
    private static int jji = 524288;
    private h jhv;
    private com.baidu.tieba.tbadkCore.videoupload.a.b jjj;

    public a(h hVar) {
        this.jhv = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hS().az("is_video_batch") == 1) {
                this.jjj = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, jji, this.jhv);
            } else {
                this.jjj = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, jjg, jjh, this.jhv);
            }
            this.jjj.a(eVar);
            return this.jjj.bp(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.jhv != null) {
                this.jhv.h(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cqP() {
        if (this.jjj != null) {
            this.jjj.cancel();
        }
    }

    public static void Bq(int i) {
        if (i <= 0) {
            jji = 524288;
        } else {
            jji = i;
        }
    }

    public static void Br(int i) {
        if (i <= 0) {
            jjg = 524288;
        } else {
            jjg = i;
        }
    }

    public static void Bs(int i) {
        if (i <= 0) {
            jjh = 6144000;
        } else {
            jjh = i;
        }
    }
}
