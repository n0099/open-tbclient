package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cd;
/* loaded from: classes.dex */
public class ad extends by {
    public static final BdUniqueId nkP = BdUniqueId.gen();
    private boolean gxC = false;
    private ca nkQ;
    private cd nkR;

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return nkP;
    }

    public boolean dOG() {
        return this.gxC;
    }

    public void xX(boolean z) {
        this.gxC = z;
    }

    public ca dOH() {
        return this.nkQ;
    }

    public void a(ca caVar) {
        this.nkQ = caVar;
    }

    public cd dOI() {
        return this.nkR;
    }

    public void a(cd cdVar) {
        this.nkR = cdVar;
    }
}
