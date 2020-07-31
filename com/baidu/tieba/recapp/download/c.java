package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes20.dex */
public class c {
    private s eah = null;
    private com.baidu.tbadk.core.util.a.a eag = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.eah != null) {
            this.eah.setCancel();
        }
    }

    public void setUrl(String str) {
        this.eag.baW().bba().mUrl = str;
    }

    private void initNetWork() {
        this.eag = new com.baidu.tbadk.core.util.a.a();
        this.eah = new d(this.eag);
        this.eag.baW().bba().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bJ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        bav().baW().a(this.eah);
        return this.eah.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a bav() {
        return this.eag;
    }
}
