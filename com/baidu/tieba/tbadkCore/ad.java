package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.ce;
/* loaded from: classes.dex */
public class ad extends bz {
    public static final BdUniqueId nqy = BdUniqueId.gen();
    private boolean gIH = false;
    private ce nqA;
    private cb nqz;

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nqy;
    }

    public boolean dOA() {
        return this.gIH;
    }

    public void xZ(boolean z) {
        this.gIH = z;
    }

    public cb dOB() {
        return this.nqz;
    }

    public void a(cb cbVar) {
        this.nqz = cbVar;
    }

    public ce dOC() {
        return this.nqA;
    }

    public void a(ce ceVar) {
        this.nqA = ceVar;
    }
}
