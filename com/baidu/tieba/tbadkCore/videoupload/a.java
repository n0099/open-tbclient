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
    private static int lpm = 524288;
    private static int lpn = 6144000;
    private static int lpo = 524288;
    private h lnq;
    private com.baidu.tieba.tbadkCore.videoupload.a.b lpp;

    public a(h hVar) {
        this.lnq = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.lpp = new d(str2, lpo, this.lnq);
            } else {
                this.lpp = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, lpm, lpn, this.lnq);
            }
            this.lpp.a(eVar);
            return this.lpp.bG(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.lnq != null) {
                this.lnq.l(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.t(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.lpp != null) {
            this.lpp.cancel();
        }
    }

    public static void Eh(int i) {
        if (i <= 0) {
            lpo = 524288;
        } else {
            lpo = i;
        }
    }

    public static void Ei(int i) {
        if (i <= 0) {
            lpm = 524288;
        } else {
            lpm = i;
        }
    }

    public static void Ej(int i) {
        if (i <= 0) {
            lpn = 6144000;
        } else {
            lpn = i;
        }
    }
}
