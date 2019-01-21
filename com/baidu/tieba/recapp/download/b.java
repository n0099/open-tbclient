package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q aBu = null;
    private com.baidu.tbadk.core.util.a.a aBt = null;

    public b() {
        Dv();
    }

    public void jj() {
        if (this.aBu != null) {
            this.aBu.jj();
        }
    }

    public void setUrl(String str) {
        this.aBt.Eu().Ex().mUrl = str;
    }

    private void Dv() {
        this.aBt = new com.baidu.tbadk.core.util.a.a();
        this.aBu = new c(this.aBt);
        this.aBt.Eu().Ex().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Dw().Eu().a(this.aBu);
        return this.aBu.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a Dw() {
        return this.aBt;
    }
}
