package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import tbclient.PbPage.DataRes;
/* loaded from: classes2.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fAT = BdUniqueId.gen();
    public bb bAn;
    private boolean fAU = false;
    private boolean fAV = false;
    private int fAW = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fAT;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.fAU = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int xB() {
        if (this.bAn != null) {
            return this.bAn.xB();
        }
        return 0;
    }

    public boolean bcn() {
        return this.bAn != null && this.bAn.xA() == 1;
    }

    public void jS(boolean z) {
        this.fAV = z;
    }

    public boolean bco() {
        return this.fAV;
    }
}
