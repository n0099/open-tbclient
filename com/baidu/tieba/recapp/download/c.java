package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes10.dex */
public class c {
    private q cVa = null;
    private com.baidu.tbadk.core.util.a.a cUZ = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.cVa != null) {
            this.cVa.setCancel();
        }
    }

    public void setUrl(String str) {
        this.cUZ.aEb().aEe().mUrl = str;
    }

    private void initNetWork() {
        this.cUZ = new com.baidu.tbadk.core.util.a.a();
        this.cVa = new d(this.cUZ);
        this.cUZ.aEb().aEe().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aDB().aEb().a(this.cVa);
        return this.cVa.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aDB() {
        return this.cUZ;
    }
}
