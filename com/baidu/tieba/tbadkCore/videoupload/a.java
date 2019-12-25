package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int keR = 524288;
    private static int keS = 6144000;
    private static int keT = 524288;
    private h kdc;
    private com.baidu.tieba.tbadkCore.videoupload.a.b keU;

    public a(h hVar) {
        this.kdc = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.keU = new d(str2, keT, this.kdc);
            } else {
                this.keU = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, keR, keS, this.kdc);
            }
            this.keU.a(eVar);
            return this.keU.bv(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.kdc != null) {
                this.kdc.j(306, -4399, com.baidu.tieba.j.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.keU != null) {
            this.keU.cancel();
        }
    }

    public static void Cx(int i) {
        if (i <= 0) {
            keT = 524288;
        } else {
            keT = i;
        }
    }

    public static void Cy(int i) {
        if (i <= 0) {
            keR = 524288;
        } else {
            keR = i;
        }
    }

    public static void Cz(int i) {
        if (i <= 0) {
            keS = 6144000;
        } else {
            keS = i;
        }
    }
}
