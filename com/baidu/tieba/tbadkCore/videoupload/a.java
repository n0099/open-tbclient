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
    private static int mUd = 524288;
    private static int mUe = 6144000;
    private static int mUf = 524288;
    private h mSh;
    private com.baidu.tieba.tbadkCore.videoupload.a.b mUg;

    public a(h hVar) {
        this.mSh = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.mUg = new d(str2, mUf, this.mSh);
            } else {
                this.mUg = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, mUd, mUe, this.mSh);
            }
            this.mUg.a(eVar);
            return this.mUg.bK(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.mSh != null) {
                this.mSh.o(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.r(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.mUg != null) {
            this.mUg.cancel();
        }
    }

    public static void JD(int i) {
        if (i <= 0) {
            mUf = 524288;
        } else {
            mUf = i;
        }
    }

    public static void JE(int i) {
        if (i <= 0) {
            mUd = 524288;
        } else {
            mUd = i;
        }
    }

    public static void JF(int i) {
        if (i <= 0) {
            mUe = 6144000;
        } else {
            mUe = i;
        }
    }
}
