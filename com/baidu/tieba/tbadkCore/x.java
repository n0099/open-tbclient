package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class x extends bh {
    public static final BdUniqueId jhG = BdUniqueId.gen();
    private boolean dvA = false;
    private bj jhH;
    private bm jhI;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhG;
    }

    public boolean bwi() {
        return this.dvA;
    }

    public void rc(boolean z) {
        this.dvA = z;
    }

    public bj cpU() {
        return this.jhH;
    }

    public void a(bj bjVar) {
        this.jhH = bjVar;
    }

    public bm cpV() {
        return this.jhI;
    }

    public void a(bm bmVar) {
        this.jhI = bmVar;
    }
}
