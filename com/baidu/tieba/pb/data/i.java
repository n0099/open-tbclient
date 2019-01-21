package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import tbclient.PbPage.DataRes;
/* loaded from: classes6.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fUA = BdUniqueId.gen();
    public bb bOl;
    private boolean fUB = false;
    private boolean fUC = false;
    private int fUD = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fUA;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.fUB = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int Bi() {
        if (this.bOl != null) {
            return this.bOl.Bi();
        }
        return 0;
    }

    public boolean bid() {
        return this.bOl != null && this.bOl.Bh() == 1;
    }

    public void kz(boolean z) {
        this.fUC = z;
    }

    public boolean bie() {
        return this.fUC;
    }
}
