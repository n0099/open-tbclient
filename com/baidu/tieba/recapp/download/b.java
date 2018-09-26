package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q arR = null;
    private com.baidu.tbadk.core.util.a.a arQ = null;

    public b() {
        zQ();
    }

    public void iW() {
        if (this.arR != null) {
            this.arR.iW();
        }
    }

    public void setUrl(String str) {
        this.arQ.AP().AS().mUrl = str;
    }

    private void zQ() {
        this.arQ = new com.baidu.tbadk.core.util.a.a();
        this.arR = new c(this.arQ);
        this.arQ.AP().AS().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        zR().AP().a(this.arR);
        return this.arR.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a zR() {
        return this.arQ;
    }
}
