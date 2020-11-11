package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes26.dex */
public class c {
    private s eME = null;
    private com.baidu.tbadk.core.util.a.a eMD = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.eME != null) {
            this.eME.setCancel();
        }
    }

    public void setUrl(String str) {
        this.eMD.brt().brx().mUrl = str;
    }

    private void initNetWork() {
        this.eMD = new com.baidu.tbadk.core.util.a.a();
        this.eME = new d(this.eMD);
        this.eMD.brt().brx().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        bqN().brt().a(this.eME);
        return this.eME.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a bqN() {
        return this.eMD;
    }
}
