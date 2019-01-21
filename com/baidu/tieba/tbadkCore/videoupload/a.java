package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hsx = 6144000;
    private static int hsy = 524288;
    private h hqM;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hsz;

    public a(h hVar) {
        this.hqM = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.hsz = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hsy, this.hqM);
            } else {
                this.hsz = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hsx, this.hqM);
            }
            this.hsz.a(eVar);
            return this.hsz.aW(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hqM != null) {
                this.hqM.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void qK() {
        if (this.hsz != null) {
            this.hsz.cancel();
        }
    }

    public static void vV(int i) {
        if (i <= 0) {
            hsy = 524288;
        } else {
            hsy = i;
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
            hsx = 6144000;
        } else {
            hsx = i;
        }
    }
}
