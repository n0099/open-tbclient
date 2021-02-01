package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes8.dex */
public class c {
    private t eZX = null;
    private com.baidu.tbadk.core.util.b.a eZW = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.eZX != null) {
            this.eZX.setCancel();
        }
    }

    public void setUrl(String str) {
        this.eZW.bta().bte().mUrl = str;
    }

    private void initNetWork() {
        this.eZW = new com.baidu.tbadk.core.util.b.a();
        this.eZX = new d(this.eZW);
        this.eZW.bta().bte().mNetType = com.baidu.tbadk.core.util.b.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.bN(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.bP(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        bsr().bta().a(this.eZX);
        return this.eZX.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.b.a bsr() {
        return this.eZW;
    }
}
