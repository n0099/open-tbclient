package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class x extends bh {
    public static final BdUniqueId jhv = BdUniqueId.gen();
    private boolean dCb = false;
    private bj jhw;
    private bm jhx;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhv;
    }

    public boolean btn() {
        return this.dCb;
    }

    public void qL(boolean z) {
        this.dCb = z;
    }

    public bj cnL() {
        return this.jhw;
    }

    public void a(bj bjVar) {
        this.jhw = bjVar;
    }

    public bm cnM() {
        return this.jhx;
    }

    public void a(bm bmVar) {
        this.jhx = bmVar;
    }
}
