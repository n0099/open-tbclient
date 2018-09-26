package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int gYq = 6144000;
    private static int gYr = 524288;
    private h gWF;
    private com.baidu.tieba.tbadkCore.videoupload.a.b gYs;

    public a(h hVar) {
        this.gWF = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iB().aO("is_video_batch") == 1) {
                this.gYs = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, gYr, this.gWF);
            } else {
                this.gYs = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, gYq, this.gWF);
            }
            this.gYs.a(eVar);
            return this.gYs.aQ(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.gWF != null) {
                this.gWF.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.m(e));
            }
            return null;
        }
    }

    public void bzR() {
        if (this.gYs != null) {
            this.gYs.cancel();
        }
    }

    public static void ut(int i) {
        if (i <= 0) {
            gYr = 524288;
        } else {
            gYr = i;
        }
    }

    public static void uu(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void uv(int i) {
        if (i <= 0) {
            gYq = 6144000;
        } else {
            gYq = i;
        }
    }
}
