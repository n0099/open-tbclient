package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes7.dex */
public class c {
    private s eXI = null;
    private com.baidu.tbadk.core.util.b.a eXH = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.eXI != null) {
            this.eXI.setCancel();
        }
    }

    public void setUrl(String str) {
        this.eXH.bsG().bsK().mUrl = str;
    }

    private void initNetWork() {
        this.eXH = new com.baidu.tbadk.core.util.b.a();
        this.eXI = new d(this.eXH);
        this.eXH.bsG().bsK().mNetType = com.baidu.tbadk.core.util.b.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bN(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bP(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        brX().bsG().a(this.eXI);
        return this.eXI.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.b.a brX() {
        return this.eXH;
    }
}
