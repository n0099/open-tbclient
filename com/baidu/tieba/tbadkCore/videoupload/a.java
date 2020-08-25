package com.baidu.tieba.tbadkCore.videoupload;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.k.h;
import com.baidu.tieba.tbadkCore.videoupload.a.d;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
/* loaded from: classes2.dex */
public class a {
    private static int mhW = 524288;
    private static int mhX = 6144000;
    private static int mhY = 524288;
    private h mgf;
    private com.baidu.tieba.tbadkCore.videoupload.a.b mhZ;

    public a(h hVar) {
        this.mgf = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.mhZ = new d(str2, mhY, this.mgf);
            } else {
                this.mhZ = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, mhW, mhX, this.mgf);
            }
            this.mhZ.a(eVar);
            return this.mhZ.bI(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.mgf != null) {
                this.mgf.l(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.mhZ != null) {
            this.mhZ.cancel();
        }
    }

    public static void Ic(int i) {
        if (i <= 0) {
            mhY = 524288;
        } else {
            mhY = i;
        }
    }

    public static void Id(int i) {
        if (i <= 0) {
            mhW = 524288;
        } else {
            mhW = i;
        }
    }

    public static void Ie(int i) {
        if (i <= 0) {
            mhX = 6144000;
        } else {
            mhX = i;
        }
    }
}
