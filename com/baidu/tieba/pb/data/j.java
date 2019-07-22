package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hIr = BdUniqueId.gen();
    public bg ccj;
    private boolean hIs = false;
    private boolean hIt = false;
    private int hIu = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hIr;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hIs = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int afT() {
        if (this.ccj != null) {
            return this.ccj.afT();
        }
        return 0;
    }

    public boolean bTd() {
        return this.ccj != null && this.ccj.afS() == 1;
    }

    public void oe(boolean z) {
        this.hIt = z;
    }

    public boolean bTe() {
        return this.hIt;
    }
}
