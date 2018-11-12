package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q axr = null;
    private com.baidu.tbadk.core.util.a.a axq = null;

    public b() {
        Ce();
    }

    public void jj() {
        if (this.axr != null) {
            this.axr.jj();
        }
    }

    public void setUrl(String str) {
        this.axq.Dd().Dg().mUrl = str;
    }

    private void Ce() {
        this.axq = new com.baidu.tbadk.core.util.a.a();
        this.axr = new c(this.axq);
        this.axq.Dd().Dg().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        Cf().Dd().a(this.axr);
        return this.axr.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a Cf() {
        return this.axq;
    }
}
