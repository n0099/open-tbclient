package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class af extends bi {
    public static final BdUniqueId fxn = BdUniqueId.gen();
    private bl fxo;
    private bo fxp;
    private boolean fxq = false;

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fxn;
    }

    public boolean biD() {
        return this.fxq;
    }

    public void lr(boolean z) {
        this.fxq = z;
    }

    public bl biE() {
        return this.fxo;
    }

    public void a(bl blVar) {
        this.fxo = blVar;
    }

    public bo biF() {
        return this.fxp;
    }

    public void a(bo boVar) {
        this.fxp = boVar;
    }
}
