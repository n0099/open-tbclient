package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q bSe = null;
    private com.baidu.tbadk.core.util.a.a bSd = null;

    public b() {
        aiD();
    }

    public void in() {
        if (this.bSe != null) {
            this.bSe.in();
        }
    }

    public void setUrl(String str) {
        this.bSd.ajE().ajH().mUrl = str;
    }

    private void aiD() {
        this.bSd = new com.baidu.tbadk.core.util.a.a();
        this.bSe = new c(this.bSd);
        this.bSd.ajE().ajH().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aF(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aiE().ajE().a(this.bSe);
        return this.bSe.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aiE() {
        return this.bSd;
    }
}
