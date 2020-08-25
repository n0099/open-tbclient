package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes20.dex */
public class c {
    private s ejP = null;
    private com.baidu.tbadk.core.util.a.a ejO = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.ejP != null) {
            this.ejP.setCancel();
        }
    }

    public void setUrl(String str) {
        this.ejO.bjv().bjz().mUrl = str;
    }

    private void initNetWork() {
        this.ejO = new com.baidu.tbadk.core.util.a.a();
        this.ejP = new d(this.ejO);
        this.ejO.bjv().bjz().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bO(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bQ(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        biQ().bjv().a(this.ejP);
        return this.ejP.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a biQ() {
        return this.ejO;
    }
}
