package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import tbclient.PbPage.DataRes;
/* loaded from: classes6.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fQK = BdUniqueId.gen();
    public bb bNv;
    private boolean fQL = false;
    private boolean fQM = false;
    private int fQN = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fQK;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.fQL = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int AV() {
        if (this.bNv != null) {
            return this.bNv.AV();
        }
        return 0;
    }

    public boolean bgN() {
        return this.bNv != null && this.bNv.AU() == 1;
    }

    public void kw(boolean z) {
        this.fQM = z;
    }

    public boolean bgO() {
        return this.fQM;
    }
}
