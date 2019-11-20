package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import tbclient.PbPage.DataRes;
/* loaded from: classes4.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hIW = BdUniqueId.gen();
    public bh cqG;
    private boolean hIX = false;
    private boolean hIY = false;
    private int hIZ = 1;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hIW;
    }

    public void b(DataRes dataRes) {
        boolean z = true;
        if (dataRes != null && dataRes.thread != null) {
            this.hIX = (dataRes.thread.origin_thread_info == null || dataRes.thread.origin_thread_info.is_deleted.intValue() != 1) ? false : false;
        }
    }

    public int ajZ() {
        if (this.cqG != null) {
            return this.cqG.ajZ();
        }
        return 0;
    }

    public boolean bRd() {
        return this.cqG != null && this.cqG.ajY() == 1;
    }

    public void nS(boolean z) {
        this.hIY = z;
    }

    public boolean bRe() {
        return this.hIY;
    }
}
