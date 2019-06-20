package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hCe = BdUniqueId.gen();
    public bg cbh;
    private boolean hCf = false;
    private boolean hCg = false;
    private int hCh = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hCe;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hCf = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int aeR() {
        if (this.cbh != null) {
            return this.cbh.aeR();
        }
        return 0;
    }

    public boolean bQs() {
        return this.cbh != null && this.cbh.aeQ() == 1;
    }

    public void nQ(boolean z) {
        this.hCg = z;
    }

    public boolean bQt() {
        return this.hCg;
    }
}
