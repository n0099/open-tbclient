package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hdl = 6144000;
    private static int hdm = 524288;
    private h hbC;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hdn;

    public a(h hVar) {
        this.hbC = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.mA().an("is_video_batch") == 1) {
                this.hdn = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hdm, this.hbC);
            } else {
                this.hdn = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hdl, this.hbC);
            }
            this.hdn.a(eVar);
            return this.hdn.aK(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hbC != null) {
                this.hbC.h(306, -4399, com.baidu.tieba.i.a.i(e));
            }
            return null;
        }
    }

    public void bxT() {
        if (this.hdn != null) {
            this.hdn.cancel();
        }
    }

    public static void vW(int i) {
        if (i <= 0) {
            hdm = 524288;
        } else {
            hdm = i;
        }
    }

    public static void vX(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vY(int i) {
        if (i <= 0) {
            hdl = 6144000;
        } else {
            hdl = i;
        }
    }
}
