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
    private static int kVr = 524288;
    private static int kVs = 6144000;
    private static int kVt = 524288;
    private h kTI;
    private com.baidu.tieba.tbadkCore.videoupload.a.b kVu;

    public a(h hVar) {
        this.kTI = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.kVu = new d(str2, kVt, this.kTI);
            } else {
                this.kVu = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, kVr, kVs, this.kTI);
            }
            this.kVu.a(eVar);
            return this.kVu.bF(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.kTI != null) {
                this.kTI.l(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.s(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.kVu != null) {
            this.kVu.cancel();
        }
    }

    public static void Du(int i) {
        if (i <= 0) {
            kVt = 524288;
        } else {
            kVt = i;
        }
    }

    public static void Dv(int i) {
        if (i <= 0) {
            kVr = 524288;
        } else {
            kVr = i;
        }
    }

    public static void Dw(int i) {
        if (i <= 0) {
            kVs = 6144000;
        } else {
            kVs = i;
        }
    }
}
