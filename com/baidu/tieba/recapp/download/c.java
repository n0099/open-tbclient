package com.baidu.tieba.recapp.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.q;
/* loaded from: classes3.dex */
public class c {
    private q cjh = null;
    private com.baidu.tbadk.core.util.a.a cjg = null;

    public c() {
        initNetWork();
    }

    public void setCancel() {
        if (this.cjh != null) {
            this.cjh.setCancel();
        }
    }

    public void setUrl(String str) {
        this.cjg.amR().amU().mUrl = str;
    }

    private void initNetWork() {
        this.cjg = new com.baidu.tbadk.core.util.a.a();
        this.cjh = new d(this.cjg);
        this.cjg.amR().amU().mNetType = com.baidu.tbadk.core.util.a.h.getNetType();
        com.baidu.adp.lib.network.a.a.setCuid(TbadkCoreApplication.getInst().getCuid());
        com.baidu.adp.lib.network.a.a.aj(TbadkCoreApplication.getInst().getCuidGalaxy2());
        com.baidu.adp.lib.network.a.a.ak(TbadkCoreApplication.getInst().getCuidGid());
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        return downloadFile(str, handler, i, i2, i3, false);
    }

    public boolean downloadFile(String str, Handler handler, int i, int i2, int i3, boolean z) {
        amr().amR().a(this.cjh);
        return this.cjh.downloadFile(str, handler, i, i2, i3, z);
    }

    public com.baidu.tbadk.core.util.a.a amr() {
        return this.cjg;
    }
}
