package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cd;
/* loaded from: classes.dex */
public class ad extends by {
    public static final BdUniqueId nkR = BdUniqueId.gen();
    private boolean gxE = false;
    private ca nkS;
    private cd nkT;

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return nkR;
    }

    public boolean dOH() {
        return this.gxE;
    }

    public void xX(boolean z) {
        this.gxE = z;
    }

    public ca dOI() {
        return this.nkS;
    }

    public void a(ca caVar) {
        this.nkS = caVar;
    }

    public cd dOJ() {
        return this.nkT;
    }

    public void a(cd cdVar) {
        this.nkT = cdVar;
    }
}
