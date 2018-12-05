package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q aAR = null;
    private com.baidu.tbadk.core.util.a.a aAQ = null;

    public b() {
        Di();
    }

    public void jj() {
        if (this.aAR != null) {
            this.aAR.jj();
        }
    }

    public void setUrl(String str) {
        this.aAQ.Eh().Ek().mUrl = str;
    }

    private void Di() {
        this.aAQ = new com.baidu.tbadk.core.util.a.a();
        this.aAR = new c(this.aAQ);
        this.aAQ.Eh().Ek().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Dj().Eh().a(this.aAR);
        return this.aAR.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a Dj() {
        return this.aAQ;
    }
}
