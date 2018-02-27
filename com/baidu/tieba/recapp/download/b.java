package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q aVQ = null;
    private com.baidu.tbadk.core.util.a.a aVP = null;

    public b() {
        Cx();
    }

    public void mV() {
        if (this.aVQ != null) {
            this.aVQ.mV();
        }
    }

    public void setUrl(String str) {
        this.aVP.Dv().Dy().mUrl = str;
    }

    private void Cx() {
        this.aVP = new com.baidu.tbadk.core.util.a.a();
        this.aVQ = new c(this.aVP);
        this.aVP.Dv().Dy().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ar(TbadkCoreApplication.getInst().getCuid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cy().Dv().a(this.aVQ);
        return this.aVQ.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a Cy() {
        return this.aVP;
    }
}
