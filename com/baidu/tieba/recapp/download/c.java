package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes7.dex */
public class c {
    private t fbw = null;
    private com.baidu.tbadk.core.util.b.a fbv = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.fbw != null) {
            this.fbw.setCancel();
        }
    }

    public void setUrl(String str) {
        this.fbv.btd().bth().mUrl = str;
    }

    private void initNetWork() {
        this.fbv = new com.baidu.tbadk.core.util.b.a();
        this.fbw = new d(this.fbv);
        this.fbv.btd().bth().mNetType = com.baidu.tbadk.core.util.b.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bR(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bT(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        bsu().btd().a(this.fbw);
        return this.fbw.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.b.a bsu() {
        return this.fbv;
    }
}
