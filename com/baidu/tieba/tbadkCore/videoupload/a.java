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
    private static int lQn = 524288;
    private static int lQo = 6144000;
    private static int lQp = 524288;
    private h lOv;
    private com.baidu.tieba.tbadkCore.videoupload.a.b lQq;

    public a(h hVar) {
        this.lOv = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.lQq = new d(str2, lQp, this.lOv);
            } else {
                this.lQq = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, lQn, lQo, this.lOv);
            }
            this.lQq.a(eVar);
            return this.lQq.bD(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.lOv != null) {
                this.lOv.m(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.s(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.lQq != null) {
            this.lQq.cancel();
        }
    }

    public static void FF(int i) {
        if (i <= 0) {
            lQp = 524288;
        } else {
            lQp = i;
        }
    }

    public static void FG(int i) {
        if (i <= 0) {
            lQn = 524288;
        } else {
            lQn = i;
        }
    }

    public static void FH(int i) {
        if (i <= 0) {
            lQo = 6144000;
        } else {
            lQo = i;
        }
    }
}
