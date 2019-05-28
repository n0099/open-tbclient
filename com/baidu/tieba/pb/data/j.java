package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hCd = BdUniqueId.gen();
    public bg cbg;
    private boolean hCe = false;
    private boolean hCf = false;
    private int hCg = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hCd;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hCe = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int aeR() {
        if (this.cbg != null) {
            return this.cbg.aeR();
        }
        return 0;
    }

    public boolean bQr() {
        return this.cbg != null && this.cbg.aeQ() == 1;
    }

    public void nP(boolean z) {
        this.hCf = z;
    }

    public boolean bQs() {
        return this.hCf;
    }
}
