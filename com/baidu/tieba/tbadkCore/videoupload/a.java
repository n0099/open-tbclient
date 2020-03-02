package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int kjx = 524288;
    private static int kjy = 6144000;
    private static int kjz = 524288;
    private h khN;
    private com.baidu.tieba.tbadkCore.videoupload.a.b kjA;

    public a(h hVar) {
        this.khN = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.kjA = new d(str2, kjz, this.khN);
            } else {
                this.kjA = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, kjx, kjy, this.khN);
            }
            this.kjA.a(eVar);
            return this.kjA.bv(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.khN != null) {
                this.khN.l(306, -4399, com.baidu.tieba.k.a.q(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.kjA != null) {
            this.kjA.cancel();
        }
    }

    public static void CI(int i) {
        if (i <= 0) {
            kjz = 524288;
        } else {
            kjz = i;
        }
    }

    public static void CJ(int i) {
        if (i <= 0) {
            kjx = 524288;
        } else {
            kjx = i;
        }
    }

    public static void CK(int i) {
        if (i <= 0) {
            kjy = 6144000;
        } else {
            kjy = i;
        }
    }
}
