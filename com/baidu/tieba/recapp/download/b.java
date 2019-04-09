package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q bJt = null;
    private com.baidu.tbadk.core.util.a.a bJs = null;

    public b() {
        acD();
    }

    public void jl() {
        if (this.bJt != null) {
            this.bJt.jl();
        }
    }

    public void setUrl(String str) {
        this.bJs.adC().adF().mUrl = str;
    }

    private void acD() {
        this.bJs = new com.baidu.tbadk.core.util.a.a();
        this.bJt = new c(this.bJs);
        this.bJs.adC().adF().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        acE().adC().a(this.bJt);
        return this.bJt.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a acE() {
        return this.bJs;
    }
}
