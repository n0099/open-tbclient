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
    private static int mHt = 524288;
    private static int mHu = 6144000;
    private static int mHv = 524288;
    private h mFB;
    private com.baidu.tieba.tbadkCore.videoupload.a.b mHw;

    public a(h hVar) {
        this.mFB = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.mHw = new d(str2, mHv, this.mFB);
            } else {
                this.mHw = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, mHt, mHu, this.mFB);
            }
            this.mHw.a(eVar);
            return this.mHw.bJ(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.mFB != null) {
                this.mFB.n(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.mHw != null) {
            this.mHw.cancel();
        }
    }

    public static void Jl(int i) {
        if (i <= 0) {
            mHv = 524288;
        } else {
            mHv = i;
        }
    }

    public static void Jm(int i) {
        if (i <= 0) {
            mHt = 524288;
        } else {
            mHt = i;
        }
    }

    public static void Jn(int i) {
        if (i <= 0) {
            mHu = 6144000;
        } else {
            mHu = i;
        }
    }
}
