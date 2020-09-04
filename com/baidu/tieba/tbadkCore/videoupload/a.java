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
    private static int mim = 524288;
    private static int mio = 6144000;
    private static int mip = 524288;
    private h mgu;
    private com.baidu.tieba.tbadkCore.videoupload.a.b miq;

    public a(h hVar) {
        this.mgu = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.miq = new d(str2, mip, this.mgu);
            } else {
                this.miq = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, mim, mio, this.mgu);
            }
            this.miq.a(eVar);
            return this.miq.bI(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.mgu != null) {
                this.mgu.l(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.miq != null) {
            this.miq.cancel();
        }
    }

    public static void Ic(int i) {
        if (i <= 0) {
            mip = 524288;
        } else {
            mip = i;
        }
    }

    public static void Id(int i) {
        if (i <= 0) {
            mim = 524288;
        } else {
            mim = i;
        }
    }

    public static void Ie(int i) {
        if (i <= 0) {
            mio = 6144000;
        } else {
            mio = i;
        }
    }
}
