package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class ac extends bw {
    public static final BdUniqueId mnI = BdUniqueId.gen();
    private boolean fND = false;
    private by mnJ;
    private cb mnK;

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mnI;
    }

    public boolean dAc() {
        return this.fND;
    }

    public void wi(boolean z) {
        this.fND = z;
    }

    public by dAd() {
        return this.mnJ;
    }

    public void a(by byVar) {
        this.mnJ = byVar;
    }

    public cb dAe() {
        return this.mnK;
    }

    public void a(cb cbVar) {
        this.mnK = cbVar;
    }
}
