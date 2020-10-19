package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class ac extends bw {
    public static final BdUniqueId mDn = BdUniqueId.gen();
    private boolean fZU = false;
    private by mDo;
    private cb mDp;

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mDn;
    }

    public boolean dDO() {
        return this.fZU;
    }

    public void wP(boolean z) {
        this.fZU = z;
    }

    public by dDP() {
        return this.mDo;
    }

    public void a(by byVar) {
        this.mDo = byVar;
    }

    public cb dDQ() {
        return this.mDp;
    }

    public void a(cb cbVar) {
        this.mDp = cbVar;
    }
}
