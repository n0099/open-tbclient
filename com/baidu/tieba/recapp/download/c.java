package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes25.dex */
public class c {
    private s eLD = null;
    private com.baidu.tbadk.core.util.a.a eLC = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.eLD != null) {
            this.eLD.setCancel();
        }
    }

    public void setUrl(String str) {
        this.eLC.bqH().bqL().mUrl = str;
    }

    private void initNetWork() {
        this.eLC = new com.baidu.tbadk.core.util.a.a();
        this.eLD = new d(this.eLC);
        this.eLC.bqH().bqL().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        bqa().bqH().a(this.eLD);
        return this.eLD.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a bqa() {
        return this.eLC;
    }
}
