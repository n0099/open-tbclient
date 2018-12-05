package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int chunkLength = 524288;
    private static int hoc = 6144000;
    private static int hod = 524288;
    private h hms;
    private com.baidu.tieba.tbadkCore.videoupload.a.b hoe;

    public a(h hVar) {
        this.hms = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (d.iQ().aO("is_video_batch") == 1) {
                this.hoe = new com.baidu.tieba.tbadkCore.videoupload.a.d(str2, hod, this.hms);
            } else {
                this.hoe = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, chunkLength, hoc, this.hms);
            }
            this.hoe.a(eVar);
            return this.hoe.aV(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.hms != null) {
                this.hms.e(MsgConstants.TRACK_MODEL_SHOWING, -4399, com.baidu.tieba.j.a.o(e));
            }
            return null;
        }
    }

    public void qG() {
        if (this.hoe != null) {
            this.hoe.cancel();
        }
    }

    public static void vF(int i) {
        if (i <= 0) {
            hod = 524288;
        } else {
            hod = i;
        }
    }

    public static void vG(int i) {
        if (i <= 0) {
            chunkLength = 524288;
        } else {
            chunkLength = i;
        }
    }

    public static void vH(int i) {
        if (i <= 0) {
            hoc = 6144000;
        } else {
            hoc = i;
        }
    }
}
