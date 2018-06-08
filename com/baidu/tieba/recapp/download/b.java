package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes3.dex */
public class b {
    private r apt = null;
    private com.baidu.tbadk.core.util.a.a aps = null;

    public b() {
        yI();
    }

    public void hP() {
        if (this.apt != null) {
            this.apt.hP();
        }
    }

    public void setUrl(String str) {
        this.aps.zI().zL().mUrl = str;
    }

    private void yI() {
        this.aps = new com.baidu.tbadk.core.util.a.a();
        this.apt = new c(this.aps);
        this.aps.zI().zL().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.aA(TbadkCoreApplication.getInst().getCuid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return a(str, handler, i, i2, i3, false);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3, boolean z) {
        yJ().zI().a(this.apt);
        return this.apt.a(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a yJ() {
        return this.aps;
    }
}
