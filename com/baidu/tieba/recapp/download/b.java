package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q awE = null;
    private com.baidu.tbadk.core.util.a.a awD = null;

    public b() {
        BX();
    }

    public void jl() {
        if (this.awE != null) {
            this.awE.jl();
        }
    }

    public void setUrl(String str) {
        this.awD.CW().CZ().mUrl = str;
    }

    private void BX() {
        this.awD = new com.baidu.tbadk.core.util.a.a();
        this.awE = new c(this.awD);
        this.awD.CW().CZ().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        BY().CW().a(this.awE);
        return this.awE.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a BY() {
        return this.awD;
    }
}
