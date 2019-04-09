package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class i implements m {
    public static final BdUniqueId hkA = BdUniqueId.gen();
    public bg bTo;
    private boolean hkB = false;
    private boolean hkC = false;
    private int hkD = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hkA;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hkB = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int aak() {
        if (this.bTo != null) {
            return this.bTo.aak();
        }
        return 0;
    }

    public boolean bIx() {
        return this.bTo != null && this.bTo.aaj() == 1;
    }

    public void na(boolean z) {
        this.hkC = z;
    }

    public boolean bIy() {
        return this.hkC;
    }
}
