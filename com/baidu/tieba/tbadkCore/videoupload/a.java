package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int kll = 524288;
    private static int klm = 6144000;
    private static int kln = 524288;
    private h kjC;
    private com.baidu.tieba.tbadkCore.videoupload.a.b klo;

    public a(h hVar) {
        this.kjC = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.klo = new d(str2, kln, this.kjC);
            } else {
                this.klo = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, kll, klm, this.kjC);
            }
            this.klo.a(eVar);
            return this.klo.bv(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.kjC != null) {
                this.kjC.l(306, -4399, com.baidu.tieba.k.a.q(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.klo != null) {
            this.klo.cancel();
        }
    }

    public static void CQ(int i) {
        if (i <= 0) {
            kln = 524288;
        } else {
            kln = i;
        }
    }

    public static void CR(int i) {
        if (i <= 0) {
            kll = 524288;
        } else {
            kll = i;
        }
    }

    public static void CS(int i) {
        if (i <= 0) {
            klm = 6144000;
        } else {
            klm = i;
        }
    }
}
