package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.ce;
/* loaded from: classes.dex */
public class ad extends bz {
    public static final BdUniqueId nqz = BdUniqueId.gen();
    private boolean gIH = false;
    private cb nqA;
    private ce nqB;

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nqz;
    }

    public boolean dOz() {
        return this.gIH;
    }

    public void xZ(boolean z) {
        this.gIH = z;
    }

    public cb dOA() {
        return this.nqA;
    }

    public void a(cb cbVar) {
        this.nqA = cbVar;
    }

    public ce dOB() {
        return this.nqB;
    }

    public void a(ce ceVar) {
        this.nqB = ceVar;
    }
}
