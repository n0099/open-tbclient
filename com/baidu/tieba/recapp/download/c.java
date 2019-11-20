package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class c {
    private q ciq = null;
    private com.baidu.tbadk.core.util.a.a cip = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.ciq != null) {
            this.ciq.setCancel();
        }
    }

    public void setUrl(String str) {
        this.cip.amP().amS().mUrl = str;
    }

    private void initNetWork() {
        this.cip = new com.baidu.tbadk.core.util.a.a();
        this.ciq = new d(this.cip);
        this.cip.amP().amS().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.ak(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        amp().amP().a(this.ciq);
        return this.ciq.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a amp() {
        return this.cip;
    }
}
