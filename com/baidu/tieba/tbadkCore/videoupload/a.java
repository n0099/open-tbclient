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
    private static int nuQ = 524288;
    private static int nuR = 6144000;
    private static int nuS = 524288;
    private g nsO;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nuT;

    public a(g gVar) {
        this.nsO = gVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nuT = new d(str2, nuS, this.nsO);
            } else {
                this.nuT = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nuQ, nuR, this.nsO);
            }
            this.nuT.a(eVar);
            return this.nuT.bV(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.nsO != null) {
                this.nsO.p(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.p(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nuT != null) {
            this.nuT.cancel();
        }
    }

    public static void Lf(int i) {
        if (i <= 0) {
            nuS = 524288;
        } else {
            nuS = i;
        }
    }

    public static void Lg(int i) {
        if (i <= 0) {
            nuQ = 524288;
        } else {
            nuQ = i;
        }
    }

    public static void Lh(int i) {
        if (i <= 0) {
            nuR = 6144000;
        } else {
            nuR = i;
        }
    }
}
