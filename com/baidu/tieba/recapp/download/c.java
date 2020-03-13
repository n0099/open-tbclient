package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes13.dex */
public class c {
    private q cZo = null;
    private com.baidu.tbadk.core.util.a.a cZn = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.cZo != null) {
            this.cZo.setCancel();
        }
    }

    public void setUrl(String str) {
        this.cZn.aGH().aGK().mUrl = str;
    }

    private void initNetWork() {
        this.cZn = new com.baidu.tbadk.core.util.a.a();
        this.cZo = new d(this.cZn);
        this.cZn.aGH().aGK().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.av(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.aw(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aGg().aGH().a(this.cZo);
        return this.cZo.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aGg() {
        return this.cZn;
    }
}
