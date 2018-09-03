package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes3.dex */
public class b {
    private r apu = null;
    private com.baidu.tbadk.core.util.a.a apt = null;

    public b() {
        yL();
    }

    public void hQ() {
        if (this.apu != null) {
            this.apu.hQ();
        }
    }

    public void setUrl(String str) {
        this.apt.zK().zN().mUrl = str;
    }

    private void yL() {
        this.apt = new com.baidu.tbadk.core.util.a.a();
        this.apu = new c(this.apt);
        this.apt.zK().zN().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aB(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        yM().zK().a(this.apu);
        return this.apu.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a yM() {
        return this.apt;
    }
}
