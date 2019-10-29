package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hJN = BdUniqueId.gen();
    public bh cry;
    private boolean hJO = false;
    private boolean hJP = false;
    private int hJQ = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hJN;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hJO = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int akb() {
        if (this.cry != null) {
            return this.cry.akb();
        }
        return 0;
    }

    public boolean bRf() {
        return this.cry != null && this.cry.aka() == 1;
    }

    public void nS(boolean z) {
        this.hJP = z;
    }

    public boolean bRg() {
        return this.hJP;
    }
}
