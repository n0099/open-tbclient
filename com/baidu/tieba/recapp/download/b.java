package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes3.dex */
public class b {
    private r apS = null;
    private com.baidu.tbadk.core.util.a.a apR = null;

    public b() {
        yW();
    }

    public void hP() {
        if (this.apS != null) {
            this.apS.hP();
        }
    }

    public void setUrl(String str) {
        this.apR.zX().Aa().mUrl = str;
    }

    private void yW() {
        this.apR = new com.baidu.tbadk.core.util.a.a();
        this.apS = new c(this.apR);
        this.apR.zX().Aa().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aA(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aB(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aC(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        yX().zX().a(this.apS);
        return this.apS.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a yX() {
        return this.apR;
    }
}
