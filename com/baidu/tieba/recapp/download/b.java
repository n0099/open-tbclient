package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q bJp = null;
    private com.baidu.tbadk.core.util.a.a bJo = null;

    public b() {
        acG();
    }

    public void jl() {
        if (this.bJp != null) {
            this.bJp.jl();
        }
    }

    public void setUrl(String str) {
        this.bJo.adF().adI().mUrl = str;
    }

    private void acG() {
        this.bJo = new com.baidu.tbadk.core.util.a.a();
        this.bJp = new c(this.bJo);
        this.bJo.adF().adI().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        acH().adF().a(this.bJp);
        return this.bJp.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a acH() {
        return this.bJo;
    }
}
