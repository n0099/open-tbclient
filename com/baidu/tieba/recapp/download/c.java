package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes13.dex */
public class c {
    private q dMY = null;
    private com.baidu.tbadk.core.util.a.a dMX = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.dMY != null) {
            this.dMY.setCancel();
        }
    }

    public void setUrl(String str) {
        this.dMX.aVa().aVe().mUrl = str;
    }

    private void initNetWork() {
        this.dMX = new com.baidu.tbadk.core.util.a.a();
        this.dMY = new d(this.dMX);
        this.dMX.aVa().aVe().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bK(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bM(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aUA().aVa().a(this.dMY);
        return this.dMY.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aUA() {
        return this.dMX;
    }
}
