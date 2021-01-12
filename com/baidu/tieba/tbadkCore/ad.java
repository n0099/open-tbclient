package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.ce;
/* loaded from: classes.dex */
public class ad extends bz {
    public static final BdUniqueId nlR = BdUniqueId.gen();
    private boolean gEb = false;
    private cb nlS;
    private ce nlT;

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nlR;
    }

    public boolean dKI() {
        return this.gEb;
    }

    public void xV(boolean z) {
        this.gEb = z;
    }

    public cb dKJ() {
        return this.nlS;
    }

    public void a(cb cbVar) {
        this.nlS = cbVar;
    }

    public ce dKK() {
        return this.nlT;
    }

    public void a(ce ceVar) {
        this.nlT = ceVar;
    }
}
