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
    private static int nph = 524288;
    private static int npi = 6144000;
    private static int npj = 524288;
    private h nnd;
    private com.baidu.tieba.tbadkCore.videoupload.a.b npk;

    public a(h hVar) {
        this.nnd = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.npk = new d(str2, npj, this.nnd);
            } else {
                this.npk = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nph, npi, this.nnd);
            }
            this.npk.a(eVar);
            return this.npk.bO(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.nnd != null) {
                this.nnd.o(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.npk != null) {
            this.npk.cancel();
        }
    }

    public static void Lj(int i) {
        if (i <= 0) {
            npj = 524288;
        } else {
            npj = i;
        }
    }

    public static void Lk(int i) {
        if (i <= 0) {
            nph = 524288;
        } else {
            nph = i;
        }
    }

    public static void Ll(int i) {
        if (i <= 0) {
            npi = 6144000;
        } else {
            npi = i;
        }
    }
}
