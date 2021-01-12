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
    private static int nqk = 524288;
    private static int nql = 6144000;
    private static int nqm = 524288;
    private g noh;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nqn;

    public a(g gVar) {
        this.noh = gVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nqn = new d(str2, nqm, this.noh);
            } else {
                this.nqn = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nqk, nql, this.noh);
            }
            this.nqn.a(eVar);
            return this.nqn.bV(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.noh != null) {
                this.noh.p(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.p(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nqn != null) {
            this.nqn.cancel();
        }
    }

    public static void Jy(int i) {
        if (i <= 0) {
            nqm = 524288;
        } else {
            nqm = i;
        }
    }

    public static void Jz(int i) {
        if (i <= 0) {
            nqk = 524288;
        } else {
            nqk = i;
        }
    }

    public static void JA(int i) {
        if (i <= 0) {
            nql = 6144000;
        } else {
            nql = i;
        }
    }
}
