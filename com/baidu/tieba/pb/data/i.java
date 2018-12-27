package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import tbclient.PbPage.DataRes;
/* loaded from: classes6.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fTC = BdUniqueId.gen();
    public bb bNy;
    private boolean fTD = false;
    private boolean fTE = false;
    private int fTF = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTC;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.fTD = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int AV() {
        if (this.bNy != null) {
            return this.bNy.AV();
        }
        return 0;
    }

    public boolean bhz() {
        return this.bNy != null && this.bNy.AU() == 1;
    }

    public void kz(boolean z) {
        this.fTE = z;
    }

    public boolean bhA() {
        return this.fTE;
    }
}
