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
    private static int lnZ = 524288;
    private static int loa = 6144000;
    private static int lob = 524288;
    private h lmg;
    private com.baidu.tieba.tbadkCore.videoupload.a.b lod;

    public a(h hVar) {
        this.lmg = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.lod = new d(str2, lob, this.lmg);
            } else {
                this.lod = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, lnZ, loa, this.lmg);
            }
            this.lod.a(eVar);
            return this.lod.bG(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.lmg != null) {
                this.lmg.l(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.t(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.lod != null) {
            this.lod.cancel();
        }
    }

    public static void Ef(int i) {
        if (i <= 0) {
            lob = 524288;
        } else {
            lob = i;
        }
    }

    public static void Eg(int i) {
        if (i <= 0) {
            lnZ = 524288;
        } else {
            lnZ = i;
        }
    }

    public static void Eh(int i) {
        if (i <= 0) {
            loa = 6144000;
        } else {
            loa = i;
        }
    }
}
