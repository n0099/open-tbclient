package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q bJs = null;
    private com.baidu.tbadk.core.util.a.a bJr = null;

    public b() {
        acD();
    }

    public void jl() {
        if (this.bJs != null) {
            this.bJs.jl();
        }
    }

    public void setUrl(String str) {
        this.bJr.adC().adF().mUrl = str;
    }

    private void acD() {
        this.bJr = new com.baidu.tbadk.core.util.a.a();
        this.bJs = new c(this.bJr);
        this.bJr.adC().adF().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aS(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aU(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        acE().adC().a(this.bJs);
        return this.bJs.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a acE() {
        return this.bJr;
    }
}
