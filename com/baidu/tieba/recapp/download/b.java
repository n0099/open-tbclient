package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q aVS = null;
    private com.baidu.tbadk.core.util.a.a aVR = null;

    public b() {
        Cy();
    }

    public void mV() {
        if (this.aVS != null) {
            this.aVS.mV();
        }
    }

    public void setUrl(String str) {
        this.aVR.Dw().Dz().mUrl = str;
    }

    private void Cy() {
        this.aVR = new com.baidu.tbadk.core.util.a.a();
        this.aVS = new c(this.aVR);
        this.aVR.Dw().Dz().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cz().Dw().a(this.aVS);
        return this.aVS.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a Cz() {
        return this.aVR;
    }
}
