package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import tbclient.PbPage.DataRes;
/* loaded from: classes6.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fUz = BdUniqueId.gen();
    public bb bOk;
    private boolean fUA = false;
    private boolean fUB = false;
    private int fUC = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fUz;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.fUA = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int Bi() {
        if (this.bOk != null) {
            return this.bOk.Bi();
        }
        return 0;
    }

    public boolean bid() {
        return this.bOk != null && this.bOk.Bh() == 1;
    }

    public void kz(boolean z) {
        this.fUB = z;
    }

    public boolean bie() {
        return this.fUB;
    }
}
