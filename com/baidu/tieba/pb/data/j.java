package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hJk = BdUniqueId.gen();
    public bh ccq;
    private boolean hJl = false;
    private boolean hJm = false;
    private int hJn = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hJk;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hJl = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int afU() {
        if (this.ccq != null) {
            return this.ccq.afU();
        }
        return 0;
    }

    public boolean bTr() {
        return this.ccq != null && this.ccq.afT() == 1;
    }

    public void oe(boolean z) {
        this.hJm = z;
    }

    public boolean bTs() {
        return this.hJm;
    }
}
