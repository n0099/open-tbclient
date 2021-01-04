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
    private static int nuR = 524288;
    private static int nuS = 6144000;
    private static int nuT = 524288;
    private g nsP;
    private com.baidu.tieba.tbadkCore.videoupload.a.b nuU;

    public a(g gVar) {
        this.nsP = gVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.nuU = new d(str2, nuT, this.nsP);
            } else {
                this.nuU = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, nuR, nuS, this.nsP);
            }
            this.nuU.a(eVar);
            return this.nuU.bV(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.nsP != null) {
                this.nsP.p(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.l.a.p(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.nuU != null) {
            this.nuU.cancel();
        }
    }

    public static void Lf(int i) {
        if (i <= 0) {
            nuT = 524288;
        } else {
            nuT = i;
        }
    }

    public static void Lg(int i) {
        if (i <= 0) {
            nuR = 524288;
        } else {
            nuR = i;
        }
    }

    public static void Lh(int i) {
        if (i <= 0) {
            nuS = 6144000;
        } else {
            nuS = i;
        }
    }
}
