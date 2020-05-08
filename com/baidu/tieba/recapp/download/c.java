package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes13.dex */
public class c {
    private q dyT = null;
    private com.baidu.tbadk.core.util.a.a dyS = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.dyT != null) {
            this.dyT.setCancel();
        }
    }

    public void setUrl(String str) {
        this.dyS.aOW().aPa().mUrl = str;
    }

    private void initNetWork() {
        this.dyS = new com.baidu.tbadk.core.util.a.a();
        this.dyT = new d(this.dyS);
        this.dyS.aOW().aPa().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bK(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aOw().aOW().a(this.dyT);
        return this.dyT.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aOw() {
        return this.dyS;
    }
}
