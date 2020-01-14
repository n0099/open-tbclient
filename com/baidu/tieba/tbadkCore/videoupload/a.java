package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private h kgK;
    private com.baidu.tieba.tbadkCore.videoupload.a.b kiC;
    private static int kiz = 524288;
    private static int kiA = 6144000;
    private static int kiB = 524288;

    public a(h hVar) {
        this.kgK = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.kiC = new d(str2, kiB, this.kgK);
            } else {
                this.kiC = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, kiz, kiA, this.kgK);
            }
            this.kiC.a(eVar);
            return this.kiC.bw(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.kgK != null) {
                this.kgK.l(306, -4399, com.baidu.tieba.j.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.kiC != null) {
            this.kiC.cancel();
        }
    }

    public static void CC(int i) {
        if (i <= 0) {
            kiB = 524288;
        } else {
            kiB = i;
        }
    }

    public static void CD(int i) {
        if (i <= 0) {
            kiz = 524288;
        } else {
            kiz = i;
        }
    }

    public static void CE(int i) {
        if (i <= 0) {
            kiA = 6144000;
        } else {
            kiA = i;
        }
    }
}
