package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
/* loaded from: classes.dex */
public class x extends bh {
    public static final BdUniqueId jfl = BdUniqueId.gen();
    private boolean dtP = false;
    private bj jfm;
    private bm jfn;

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfl;
    }

    public boolean bvu() {
        return this.dtP;
    }

    public void qZ(boolean z) {
        this.dtP = z;
    }

    public bj cpg() {
        return this.jfm;
    }

    public void a(bj bjVar) {
        this.jfm = bjVar;
    }

    public bm cph() {
        return this.jfn;
    }

    public void a(bm bmVar) {
        this.jfn = bmVar;
    }
}
