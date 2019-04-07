package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class i implements m {
    public static final BdUniqueId hkz = BdUniqueId.gen();
    public bg bTn;
    private boolean hkA = false;
    private boolean hkB = false;
    private int hkC = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hkz;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hkA = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int aak() {
        if (this.bTn != null) {
            return this.bTn.aak();
        }
        return 0;
    }

    public boolean bIx() {
        return this.bTn != null && this.bTn.aaj() == 1;
    }

    public void na(boolean z) {
        this.hkB = z;
    }

    public boolean bIy() {
        return this.hkB;
    }
}
