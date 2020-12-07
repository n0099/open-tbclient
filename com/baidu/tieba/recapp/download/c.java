package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes26.dex */
public class c {
    private s eSP = null;
    private com.baidu.tbadk.core.util.a.a eSO = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.eSP != null) {
            this.eSP.setCancel();
        }
    }

    public void setUrl(String str) {
        this.eSO.bue().bui().mUrl = str;
    }

    private void initNetWork() {
        this.eSO = new com.baidu.tbadk.core.util.a.a();
        this.eSP = new d(this.eSO);
        this.eSO.bue().bui().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bT(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bV(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        btv().bue().a(this.eSP);
        return this.eSP.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a btv() {
        return this.eSO;
    }
}
