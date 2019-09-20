package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class c {
    private q bSL = null;
    private com.baidu.tbadk.core.util.a.a bSK = null;

    public c() {
        aiJ();
    }

    public void in() {
        if (this.bSL != null) {
            this.bSL.in();
        }
    }

    public void setUrl(String str) {
        this.bSK.ajM().ajP().mUrl = str;
    }

    private void aiJ() {
        this.bSK = new com.baidu.tbadk.core.util.a.a();
        this.bSL = new d(this.bSK);
        this.bSK.ajM().ajP().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aF(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aiK().ajM().a(this.bSL);
        return this.bSL.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aiK() {
        return this.bSK;
    }
}
