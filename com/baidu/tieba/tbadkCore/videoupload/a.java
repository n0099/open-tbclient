package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int kiu = 524288;
    private static int kiv = 6144000;
    private static int kiw = 524288;
    private h kgF;
    private com.baidu.tieba.tbadkCore.videoupload.a.b kix;

    public a(h hVar) {
        this.kgF = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.kix = new d(str2, kiw, this.kgF);
            } else {
                this.kix = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, kiu, kiv, this.kgF);
            }
            this.kix.a(eVar);
            return this.kix.bw(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.kgF != null) {
                this.kgF.l(306, -4399, com.baidu.tieba.j.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.kix != null) {
            this.kix.cancel();
        }
    }

    public static void CC(int i) {
        if (i <= 0) {
            kiw = 524288;
        } else {
            kiw = i;
        }
    }

    public static void CD(int i) {
        if (i <= 0) {
            kiu = 524288;
        } else {
            kiu = i;
        }
    }

    public static void CE(int i) {
        if (i <= 0) {
            kiv = 6144000;
        } else {
            kiv = i;
        }
    }
}
