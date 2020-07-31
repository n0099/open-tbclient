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
    private static int lQl = 524288;
    private static int lQm = 6144000;
    private static int lQn = 524288;
    private h lOt;
    private com.baidu.tieba.tbadkCore.videoupload.a.b lQo;

    public a(h hVar) {
        this.lOt = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.lQo = new d(str2, lQn, this.lOt);
            } else {
                this.lQo = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, lQl, lQm, this.lOt);
            }
            this.lQo.a(eVar);
            return this.lQo.bD(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.lOt != null) {
                this.lOt.m(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.s(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.lQo != null) {
            this.lQo.cancel();
        }
    }

    public static void FF(int i) {
        if (i <= 0) {
            lQn = 524288;
        } else {
            lQn = i;
        }
    }

    public static void FG(int i) {
        if (i <= 0) {
            lQl = 524288;
        } else {
            lQl = i;
        }
    }

    public static void FH(int i) {
        if (i <= 0) {
            lQm = 6144000;
        } else {
            lQm = i;
        }
    }
}
