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
    private static int kVv = 524288;
    private static int kVw = 6144000;
    private static int kVx = 524288;
    private h kTM;
    private com.baidu.tieba.tbadkCore.videoupload.a.b kVy;

    public a(h hVar) {
        this.kTM = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.kVy = new d(str2, kVx, this.kTM);
            } else {
                this.kVy = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, kVv, kVw, this.kTM);
            }
            this.kVy.a(eVar);
            return this.kVy.bF(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.kTM != null) {
                this.kTM.l(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.s(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.kVy != null) {
            this.kVy.cancel();
        }
    }

    public static void Du(int i) {
        if (i <= 0) {
            kVx = 524288;
        } else {
            kVx = i;
        }
    }

    public static void Dv(int i) {
        if (i <= 0) {
            kVv = 524288;
        } else {
            kVv = i;
        }
    }

    public static void Dw(int i) {
        if (i <= 0) {
            kVw = 6144000;
        } else {
            kVw = i;
        }
    }
}
