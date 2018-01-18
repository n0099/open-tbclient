package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.i.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int haS = 6144000;
    private static int haT = 524288;
    private h gZj;
    private com.baidu.tieba.tbadkCore.videoupload.a.b haU;

    public a(h hVar) {
        this.gZj = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.mz().an("is_video_batch") == 1) {
                this.haU = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, haT, this.gZj);
            } else {
                this.haU = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, haS, this.gZj);
            }
            this.haU.a(eVar);
            return this.haU.aJ(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gZj != null) {
                this.gZj.h(306, -4399, com.baidu.tieba.i.a.i(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.haU != null) {
            this.haU.cancel();
        }
    }

    public static void vU(int i) {
        if (i <= 0) {
            haT = 524288;
        } else {
            haT = i;
        }
    }

    public static void vV(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vW(int i) {
        if (i <= 0) {
            haS = 6144000;
        } else {
            haS = i;
        }
    }
}
