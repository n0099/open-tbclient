package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class b {
    private q ahm = null;
    private com.baidu.tbadk.core.util.a.a ahl = null;

    public b() {
        vi();
    }

    public void eY() {
        if (this.ahm != null) {
            this.ahm.eY();
        }
    }

    public void setUrl(String str) {
        this.ahl.wi().wl().mUrl = str;
    }

    private void vi() {
        this.ahl = new com.baidu.tbadk.core.util.a.a();
        this.ahm = new c(this.ahl);
        this.ahl.wi().wl().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.ao(TbadkCoreApplication.getInst().getCuid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        vj().wi().a(this.ahm);
        return this.ahm.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a vj() {
        return this.ahl;
    }
}
