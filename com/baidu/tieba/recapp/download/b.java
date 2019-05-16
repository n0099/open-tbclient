package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q bRd = null;
    private com.baidu.tbadk.core.util.a.a bRc = null;

    public b() {
        ahB();
    }

    public void ie() {
        if (this.bRd != null) {
            this.bRd.ie();
        }
    }

    public void setUrl(String str) {
        this.bRc.aiB().aiE().mUrl = str;
    }

    private void ahB() {
        this.bRc = new com.baidu.tbadk.core.util.a.a();
        this.bRd = new c(this.bRc);
        this.bRc.aiB().aiE().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        ahC().aiB().a(this.bRd);
        return this.bRd.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a ahC() {
        return this.bRc;
    }
}
