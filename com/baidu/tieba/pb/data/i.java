package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import tbclient.PbPage.DataRes;
/* loaded from: classes6.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fJU = BdUniqueId.gen();
    public bb bJG;
    private boolean fJV = false;
    private boolean fJW = false;
    private int fJX = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fJU;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.fJV = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int zR() {
        if (this.bJG != null) {
            return this.bJG.zR();
        }
        return 0;
    }

    public boolean beX() {
        return this.bJG != null && this.bJG.zQ() == 1;
    }

    public void kt(boolean z) {
        this.fJW = z;
    }

    public boolean beY() {
        return this.fJW;
    }
}
