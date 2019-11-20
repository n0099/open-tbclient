package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class x extends bh {
    public static final BdUniqueId jgE = BdUniqueId.gen();
    private boolean dBk = false;
    private bj jgF;
    private bm jgG;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgE;
    }

    public boolean btl() {
        return this.dBk;
    }

    public void qL(boolean z) {
        this.dBk = z;
    }

    public bj cnJ() {
        return this.jgF;
    }

    public void a(bj bjVar) {
        this.jgF = bjVar;
    }

    public bm cnK() {
        return this.jgG;
    }

    public void a(bm bmVar) {
        this.jgG = bmVar;
    }
}
