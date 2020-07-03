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
    private static int lIX = 524288;
    private static int lIY = 6144000;
    private static int lIZ = 524288;
    private h lHf;
    private com.baidu.tieba.tbadkCore.videoupload.a.b lJa;

    public a(h hVar) {
        this.lHf = hVar;
    }

    public VideoFinishResult a(String str, String str2, int i, e eVar) {
        try {
            if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                this.lJa = new d(str2, lIZ, this.lHf);
            } else {
                this.lJa = new com.baidu.tieba.tbadkCore.videoupload.a.c(str, lIX, lIY, this.lHf);
            }
            this.lJa.a(eVar);
            return this.lJa.bF(str2, i);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            if (this.lHf != null) {
                this.lHf.l(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, com.baidu.tieba.k.a.t(e));
            }
            return null;
        }
    }

    public void cancelUpload() {
        if (this.lJa != null) {
            this.lJa.cancel();
        }
    }

    public static void Fj(int i) {
        if (i <= 0) {
            lIZ = 524288;
        } else {
            lIZ = i;
        }
    }

    public static void Fk(int i) {
        if (i <= 0) {
            lIX = 524288;
        } else {
            lIX = i;
        }
    }

    public static void Fl(int i) {
        if (i <= 0) {
            lIY = 6144000;
        } else {
            lIY = i;
        }
    }
}
