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
    private static int mrL = 524288;
    private static int mrM = 6144000;
    private static int mrN = 524288;
    private h mpU;
    private com.baidu.tieba.tbadkCore.videoupload.a.b mrO;

    public a(h hVar) {
        this.mpU = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.mrO = new d(str2, mrN, this.mpU);
            } else {
                this.mrO = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, mrL, mrM, this.mpU);
            }
            this.mrO.a(eVar);
            return this.mrO.bI(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.mpU != null) {
                this.mpU.m(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.mrO != null) {
            this.mrO.cancel();
        }
    }

    public static void IF(int i) {
        if (i <= 0) {
            mrN = 524288;
        } else {
            mrN = i;
        }
    }

    public static void IG(int i) {
        if (i <= 0) {
            mrL = 524288;
        } else {
            mrL = i;
        }
    }

    public static void IH(int i) {
        if (i <= 0) {
            mrM = 6144000;
        } else {
            mrM = i;
        }
    }
}
