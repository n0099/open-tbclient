package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.l.g;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int nzU = 524288;
    private static int nzV = 6144000;
    private static int nzW = 524288;
    private g nxU;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nzX;

    public a(g gVar) {
        this.nxU = gVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nzX = new d(str2, nzW, this.nxU);
            } else {
                this.nzX = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nzU, nzV, this.nxU);
            }
            this.nzX.a(eVar);
            return this.nzX.bW(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.nxU != null) {
                this.nxU.o(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.o(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nzX != null) {
            this.nzX.cancel();
        }
    }

    public static void JS(int i) {
        if (i <= 0) {
            nzW = 524288;
        } else {
            nzW = i;
        }
    }

    public static void JT(int i) {
        if (i <= 0) {
            nzU = 524288;
        } else {
            nzU = i;
        }
    }

    public static void JU(int i) {
        if (i <= 0) {
            nzV = 6144000;
        } else {
            nzV = i;
        }
    }
}
