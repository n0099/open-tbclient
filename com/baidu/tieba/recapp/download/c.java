package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes26.dex */
public class c {
    private s eGP = null;
    private com.baidu.tbadk.core.util.a.a eGO = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.eGP != null) {
            this.eGP.setCancel();
        }
    }

    public void setUrl(String str) {
        this.eGO.boT().boX().mUrl = str;
    }

    private void initNetWork() {
        this.eGO = new com.baidu.tbadk.core.util.a.a();
        this.eGP = new d(this.eGO);
        this.eGO.boT().boX().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bS(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        bon().boT().a(this.eGP);
        return this.eGP.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a bon() {
        return this.eGO;
    }
}
