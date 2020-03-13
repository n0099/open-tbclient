package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class x extends bj {
    public static final BdUniqueId kfN = BdUniqueId.gen();
    private boolean erH = false;
    private bl kfO;
    private bo kfP;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kfN;
    }

    public boolean cKB() {
        return this.erH;
    }

    public void sJ(boolean z) {
        this.erH = z;
    }

    public bl cKC() {
        return this.kfO;
    }

    public void a(bl blVar) {
        this.kfO = blVar;
    }

    public bo cKD() {
        return this.kfP;
    }

    public void a(bo boVar) {
        this.kfP = boVar;
    }
}
