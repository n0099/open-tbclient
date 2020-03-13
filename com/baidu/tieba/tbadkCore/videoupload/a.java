package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int kjJ = 524288;
    private static int kjK = 6144000;
    private static int kjL = 524288;
    private h khZ;
    private com.baidu.tieba.tbadkCore.videoupload.a.b kjM;

    public a(h hVar) {
        this.khZ = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.kjM = new d(str2, kjL, this.khZ);
            } else {
                this.kjM = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, kjJ, kjK, this.khZ);
            }
            this.kjM.a(eVar);
            return this.kjM.bv(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.khZ != null) {
                this.khZ.l(306, -4399, com.baidu.tieba.k.a.q(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.kjM != null) {
            this.kjM.cancel();
        }
    }

    public static void CI(int i) {
        if (i <= 0) {
            kjL = 524288;
        } else {
            kjL = i;
        }
    }

    public static void CJ(int i) {
        if (i <= 0) {
            kjJ = 524288;
        } else {
            kjJ = i;
        }
    }

    public static void CK(int i) {
        if (i <= 0) {
            kjK = 6144000;
        } else {
            kjK = i;
        }
    }
}
