package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bb;
import tbclient.PbPage.DataRes;
/* loaded from: classes6.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId fIw = BdUniqueId.gen();
    public bb bIV;
    private boolean fIx = false;
    private boolean fIy = false;
    private int fIz = 1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fIw;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.fIx = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int zK() {
        if (this.bIV != null) {
            return this.bIV.zK();
        }
        return 0;
    }

    public boolean bfz() {
        return this.bIV != null && this.bIV.zJ() == 1;
    }

    public void kj(boolean z) {
        this.fIy = z;
    }

    public boolean bfA() {
        return this.fIy;
    }
}
