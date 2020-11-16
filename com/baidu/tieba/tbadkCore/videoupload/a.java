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
    private static int nbc = 524288;
    private static int nbd = 6144000;
    private static int nbe = 524288;
    private h mZc;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nbf;

    public a(h hVar) {
        this.mZc = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nbf = new d(str2, nbe, this.mZc);
            } else {
                this.nbf = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nbc, nbd, this.mZc);
            }
            this.nbf.a(eVar);
            return this.nbf.bL(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.mZc != null) {
                this.mZc.n(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nbf != null) {
            this.nbf.cancel();
        }
    }

    public static void Kt(int i) {
        if (i <= 0) {
            nbe = 524288;
        } else {
            nbe = i;
        }
    }

    public static void Ku(int i) {
        if (i <= 0) {
            nbc = 524288;
        } else {
            nbc = i;
        }
    }

    public static void Kv(int i) {
        if (i <= 0) {
            nbd = 6144000;
        } else {
            nbd = i;
        }
    }
}
