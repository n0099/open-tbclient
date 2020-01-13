package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes11.dex */
public class c {
    private q cVk = null;
    private com.baidu.tbadk.core.util.a.a cVj = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.cVk != null) {
            this.cVk.setCancel();
        }
    }

    public void setUrl(String str) {
        this.cVj.aEu().aEx().mUrl = str;
    }

    private void initNetWork() {
        this.cVj = new com.baidu.tbadk.core.util.a.a();
        this.cVk = new d(this.cVj);
        this.cVj.aEu().aEx().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aDU().aEu().a(this.cVk);
        return this.cVk.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aDU() {
        return this.cVj;
    }
}
