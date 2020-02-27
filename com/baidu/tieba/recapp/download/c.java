package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes13.dex */
public class c {
    private q cZm = null;
    private com.baidu.tbadk.core.util.a.a cZl = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.cZm != null) {
            this.cZm.setCancel();
        }
    }

    public void setUrl(String str) {
        this.cZl.aGF().aGI().mUrl = str;
    }

    private void initNetWork() {
        this.cZl = new com.baidu.tbadk.core.util.a.a();
        this.cZm = new d(this.cZl);
        this.cZl.aGF().aGI().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aGe().aGF().a(this.cZm);
        return this.cZm.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aGe() {
        return this.cZl;
    }
}
