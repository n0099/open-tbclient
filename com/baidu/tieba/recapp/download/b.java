package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q aWc = null;
    private com.baidu.tbadk.core.util.a.a aWb = null;

    public b() {
        Cy();
    }

    public void mV() {
        if (this.aWc != null) {
            this.aWc.mV();
        }
    }

    public void setUrl(String str) {
        this.aWb.Dw().Dz().mUrl = str;
    }

    private void Cy() {
        this.aWb = new com.baidu.tbadk.core.util.a.a();
        this.aWc = new c(this.aWb);
        this.aWb.Dw().Dz().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cz().Dw().a(this.aWc);
        return this.aWc.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a Cz() {
        return this.aWb;
    }
}
