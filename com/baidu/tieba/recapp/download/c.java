package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes13.dex */
public class c {
    private r dTO = null;
    private com.baidu.tbadk.core.util.a.a dTN = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.dTO != null) {
            this.dTO.setCancel();
        }
    }

    public void setUrl(String str) {
        this.dTN.aWV().aWZ().mUrl = str;
    }

    private void initNetWork() {
        this.dTN = new com.baidu.tbadk.core.util.a.a();
        this.dTO = new d(this.dTN);
        this.dTN.aWV().aWZ().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bN(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aWu().aWV().a(this.dTO);
        return this.dTO.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aWu() {
        return this.dTN;
    }
}
