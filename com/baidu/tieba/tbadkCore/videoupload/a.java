package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hsw = 6144000;
    private static int hsx = 524288;
    private h hqL;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hsy;

    public a(h hVar) {
        this.hqL = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.hsy = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hsx, this.hqL);
            } else {
                this.hsy = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hsw, this.hqL);
            }
            this.hsy.a(eVar);
            return this.hsy.aW(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hqL != null) {
                this.hqL.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void qK() {
        if (this.hsy != null) {
            this.hsy.cancel();
        }
    }

    public static void vV(int i) {
        if (i <= 0) {
            hsx = 524288;
        } else {
            hsx = i;
        }
    }

    public static void vW(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vX(int i) {
        if (i <= 0) {
            hsw = 6144000;
        } else {
            hsw = i;
        }
    }
}
