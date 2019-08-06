package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q bSk = null;
    private com.baidu.tbadk.core.util.a.a bSj = null;

    public b() {
        aiF();
    }

    public void in() {
        if (this.bSk != null) {
            this.bSk.in();
        }
    }

    public void setUrl(String str) {
        this.bSj.ajG().ajJ().mUrl = str;
    }

    private void aiF() {
        this.bSj = new com.baidu.tbadk.core.util.a.a();
        this.bSk = new c(this.bSj);
        this.bSj.ajG().ajJ().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aD(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aE(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aF(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aiG().ajG().a(this.bSk);
        return this.bSk.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aiG() {
        return this.bSj;
    }
}
