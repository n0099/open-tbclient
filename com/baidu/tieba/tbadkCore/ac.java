package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes2.dex */
public class ac extends bw {
    public static final BdUniqueId mdU = BdUniqueId.gen();
    private boolean fKl = false;
    private by mdV;
    private cb mdW;

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mdU;
    }

    public boolean dwe() {
        return this.fKl;
    }

    public void vX(boolean z) {
        this.fKl = z;
    }

    public by dwf() {
        return this.mdV;
    }

    public void a(by byVar) {
        this.mdV = byVar;
    }

    public cb dwg() {
        return this.mdW;
    }

    public void a(cb cbVar) {
        this.mdW = cbVar;
    }
}
