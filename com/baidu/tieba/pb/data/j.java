package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hLh = BdUniqueId.gen();
    public bh cdk;
    private boolean hLi = false;
    private boolean hLj = false;
    private int hLk = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLh;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hLi = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int afY() {
        if (this.cdk != null) {
            return this.cdk.afY();
        }
        return 0;
    }

    public boolean bUe() {
        return this.cdk != null && this.cdk.afX() == 1;
    }

    public void oi(boolean z) {
        this.hLj = z;
    }

    public boolean bUf() {
        return this.hLj;
    }
}
