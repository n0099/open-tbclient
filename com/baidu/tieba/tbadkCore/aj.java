package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bc;
/* loaded from: classes.dex */
public class aj extends ax {
    public static final BdUniqueId erN = BdUniqueId.gen();
    private az erO;
    private bc erP;
    private boolean erQ = false;

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return erN;
    }

    public boolean aTm() {
        return this.erQ;
    }

    public void jy(boolean z) {
        this.erQ = z;
    }

    public az aTn() {
        return this.erO;
    }

    public void a(az azVar) {
        this.erO = azVar;
    }

    public bc aTo() {
        return this.erP;
    }

    public void a(bc bcVar) {
        this.erP = bcVar;
    }
}
