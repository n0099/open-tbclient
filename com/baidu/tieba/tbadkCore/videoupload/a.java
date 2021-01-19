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
    private static int nql = 524288;
    private static int nqm = 6144000;
    private static int nqn = 524288;
    private g noi;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nqo;

    public a(g gVar) {
        this.noi = gVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nqo = new d(str2, nqn, this.noi);
            } else {
                this.nqo = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nql, nqm, this.noi);
            }
            this.nqo.a(eVar);
            return this.nqo.bW(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.noi != null) {
                this.noi.p(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.p(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nqo != null) {
            this.nqo.cancel();
        }
    }

    public static void Jy(int i) {
        if (i <= 0) {
            nqn = 524288;
        } else {
            nqn = i;
        }
    }

    public static void Jz(int i) {
        if (i <= 0) {
            nql = 524288;
        } else {
            nql = i;
        }
    }

    public static void JA(int i) {
        if (i <= 0) {
            nqm = 6144000;
        } else {
            nqm = i;
        }
    }
}
