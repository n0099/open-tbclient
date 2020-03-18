package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes13.dex */
public class c {
    private q cZB = null;
    private com.baidu.tbadk.core.util.a.a cZA = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.cZB != null) {
            this.cZB.setCancel();
        }
    }

    public void setUrl(String str) {
        this.cZA.aGL().aGO().mUrl = str;
    }

    private void initNetWork() {
        this.cZA = new com.baidu.tbadk.core.util.a.a();
        this.cZB = new d(this.cZA);
        this.cZA.aGL().aGO().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aGk().aGL().a(this.cZB);
        return this.cZB.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aGk() {
        return this.cZA;
    }
}
