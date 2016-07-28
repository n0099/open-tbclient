package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class am extends be {
    public static final BdUniqueId fjD = BdUniqueId.gen();
    private bg fjE;
    private bj fjF;
    private boolean fjG = false;

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fjD;
    }

    public boolean beO() {
        return this.fjG;
    }

    public void kx(boolean z) {
        this.fjG = z;
    }

    public bg beP() {
        return this.fjE;
    }

    public void a(bg bgVar) {
        this.fjE = bgVar;
    }

    public bj beQ() {
        return this.fjF;
    }

    public void a(bj bjVar) {
        this.fjF = bjVar;
    }
}
