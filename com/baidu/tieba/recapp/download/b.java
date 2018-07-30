package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes3.dex */
public class b {
    private r apt = null;
    private com.baidu.tbadk.core.util.a.a aps = null;

    public b() {
        yN();
    }

    public void hQ() {
        if (this.apt != null) {
            this.apt.hQ();
        }
    }

    public void setUrl(String str) {
        this.aps.zM().zP().mUrl = str;
    }

    private void yN() {
        this.aps = new com.baidu.tbadk.core.util.a.a();
        this.apt = new c(this.aps);
        this.aps.zM().zP().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aB(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        yO().zM().a(this.apt);
        return this.apt.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a yO() {
        return this.aps;
    }
}
