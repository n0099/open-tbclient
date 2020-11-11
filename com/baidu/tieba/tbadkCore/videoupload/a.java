package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int nab = 524288;
    private static int nac = 6144000;
    private static int nad = 524288;
    private h mYk;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nae;

    public a(h hVar) {
        this.mYk = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nae = new d(str2, nad, this.mYk);
            } else {
                this.nae = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nab, nac, this.mYk);
            }
            this.nae.a(eVar);
            return this.nae.bM(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.mYk != null) {
                this.mYk.o(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nae != null) {
            this.nae.cancel();
        }
    }

    public static void JQ(int i) {
        if (i <= 0) {
            nad = 524288;
        } else {
            nad = i;
        }
    }

    public static void JR(int i) {
        if (i <= 0) {
            nab = 524288;
        } else {
            nab = i;
        }
    }

    public static void JS(int i) {
        if (i <= 0) {
            nac = 6144000;
        } else {
            nac = i;
        }
    }
}
