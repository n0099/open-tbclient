package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int kjv = 524288;
    private static int kjw = 6144000;
    private static int kjx = 524288;
    private h khL;
    private com.baidu.tieba.tbadkCore.videoupload.a.b kjy;

    public a(h hVar) {
        this.khL = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.kjy = new d(str2, kjx, this.khL);
            } else {
                this.kjy = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, kjv, kjw, this.khL);
            }
            this.kjy.a(eVar);
            return this.kjy.bv(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.khL != null) {
                this.khL.l(306, -4399, com.baidu.tieba.k.a.q(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.kjy != null) {
            this.kjy.cancel();
        }
    }

    public static void CI(int i) {
        if (i <= 0) {
            kjx = 524288;
        } else {
            kjx = i;
        }
    }

    public static void CJ(int i) {
        if (i <= 0) {
            kjv = 524288;
        } else {
            kjv = i;
        }
    }

    public static void CK(int i) {
        if (i <= 0) {
            kjw = 6144000;
        } else {
            kjw = i;
        }
    }
}
