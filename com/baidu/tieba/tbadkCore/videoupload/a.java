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
    private static int nAu = 524288;
    private static int nAv = 6144000;
    private static int nAw = 524288;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nAx;
    private g nyu;

    public a(g gVar) {
        this.nyu = gVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nAx = new d(str2, nAw, this.nyu);
            } else {
                this.nAx = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nAu, nAv, this.nyu);
            }
            this.nAx.a(eVar);
            return this.nAx.bW(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.nyu != null) {
                this.nyu.o(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.o(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nAx != null) {
            this.nAx.cancel();
        }
    }

    public static void JS(int i) {
        if (i <= 0) {
            nAw = 524288;
        } else {
            nAw = i;
        }
    }

    public static void JT(int i) {
        if (i <= 0) {
            nAu = 524288;
        } else {
            nAu = i;
        }
    }

    public static void JU(int i) {
        if (i <= 0) {
            nAv = 6144000;
        } else {
            nAv = i;
        }
    }
}
