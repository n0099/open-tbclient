package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q bJq = null;
    private com.baidu.tbadk.core.util.a.a bJp = null;

    public b() {
        acG();
    }

    public void jl() {
        if (this.bJq != null) {
            this.bJq.jl();
        }
    }

    public void setUrl(String str) {
        this.bJp.adF().adI().mUrl = str;
    }

    private void acG() {
        this.bJp = new com.baidu.tbadk.core.util.a.a();
        this.bJq = new c(this.bJp);
        this.bJp.adF().adI().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        acH().adF().a(this.bJq);
        return this.bJq.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a acH() {
        return this.bJp;
    }
}
