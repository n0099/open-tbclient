package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int jhY = 524288;
    private static int jhZ = 6144000;
    private static int jia = 524288;
    private h jgo;
    private com.baidu.tieba.tbadkCore.videoupload.a.b jib;

    public a(h hVar) {
        this.jgo = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.hS().az("is_video_batch") == 1) {
                this.jib = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, jia, this.jgo);
            } else {
                this.jib = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, jhY, jhZ, this.jgo);
            }
            this.jib.a(eVar);
            return this.jib.bp(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.jgo != null) {
                this.jgo.h(306, -4399, com.baidu.tieba.j.a.p(e));
            }
            return null;
        }
    }

    public void cqt() {
        if (this.jib != null) {
            this.jib.cancel();
        }
    }

    public static void Bo(int i) {
        if (i <= 0) {
            jia = 524288;
        } else {
            jia = i;
        }
    }

    public static void Bp(int i) {
        if (i <= 0) {
            jhY = 524288;
        } else {
            jhY = i;
        }
    }

    public static void Bq(int i) {
        if (i <= 0) {
            jhZ = 6144000;
        } else {
            jhZ = i;
        }
    }
}
