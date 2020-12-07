package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.l.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes.dex */
public class a {
    private static int npf = 524288;
    private static int npg = 6144000;
    private static int nph = 524288;
    private h nnb;
    private com.baidu.tieba.tbadkCore.videoupload.a.b npi;

    public a(h hVar) {
        this.nnb = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.npi = new d(str2, nph, this.nnb);
            } else {
                this.npi = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, npf, npg, this.nnb);
            }
            this.npi.a(eVar);
            return this.npi.bO(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.nnb != null) {
                this.nnb.o(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.npi != null) {
            this.npi.cancel();
        }
    }

    public static void Lj(int i) {
        if (i <= 0) {
            nph = 524288;
        } else {
            nph = i;
        }
    }

    public static void Lk(int i) {
        if (i <= 0) {
            npf = 524288;
        } else {
            npf = i;
        }
    }

    public static void Ll(int i) {
        if (i <= 0) {
            npg = 6144000;
        } else {
            npg = i;
        }
    }
}
