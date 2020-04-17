package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes13.dex */
public class c {
    private q dyP = null;
    private com.baidu.tbadk.core.util.a.a dyO = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.dyP != null) {
            this.dyP.setCancel();
        }
    }

    public void setUrl(String str) {
        this.dyO.aOZ().aPd().mUrl = str;
    }

    private void initNetWork() {
        this.dyO = new com.baidu.tbadk.core.util.a.a();
        this.dyP = new d(this.dyO);
        this.dyO.aOZ().aPd().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bK(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bL(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        aOy().aOZ().a(this.dyP);
        return this.dyP.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a aOy() {
        return this.dyO;
    }
}
