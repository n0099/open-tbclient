package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q bRe = null;
    private com.baidu.tbadk.core.util.a.a bRd = null;

    public b() {
        ahB();
    }

    public void ie() {
        if (this.bRe != null) {
            this.bRe.ie();
        }
    }

    public void setUrl(String str) {
        this.bRd.aiB().aiE().mUrl = str;
    }

    private void ahB() {
        this.bRd = new com.baidu.tbadk.core.util.a.a();
        this.bRe = new c(this.bRd);
        this.bRd.aiB().aiE().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        ahC().aiB().a(this.bRe);
        return this.bRe.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a ahC() {
        return this.bRd;
    }
}
