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
    private g nAz;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nCC;
    private static int nCz = 524288;
    private static int nCA = 6144000;
    private static int nCB = 524288;

    public a(g gVar) {
        this.nAz = gVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nCC = new d(str2, nCB, this.nAz);
            } else {
                this.nCC = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nCz, nCA, this.nAz);
            }
            this.nCC.a(eVar);
            return this.nCC.bW(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.nAz != null) {
                this.nAz.o(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.o(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nCC != null) {
            this.nCC.cancel();
        }
    }

    public static void JX(int i) {
        if (i <= 0) {
            nCB = 524288;
        } else {
            nCB = i;
        }
    }

    public static void JY(int i) {
        if (i <= 0) {
            nCz = 524288;
        } else {
            nCz = i;
        }
    }

    public static void JZ(int i) {
        if (i <= 0) {
            nCA = 6144000;
        } else {
            nCA = i;
        }
    }
}
