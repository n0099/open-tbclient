package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes13.dex */
public class c {
    private q cZn = null;
    private com.baidu.tbadk.core.util.a.a cZm = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.cZn != null) {
            this.cZn.setCancel();
        }
    }

    public void setUrl(String str) {
        this.cZm.aGH().aGK().mUrl = str;
    }

    private void initNetWork() {
        this.cZm = new com.baidu.tbadk.core.util.a.a();
        this.cZn = new d(this.cZm);
        this.cZm.aGH().aGK().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aGg().aGH().a(this.cZn);
        return this.cZn.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aGg() {
        return this.cZm;
    }
}
