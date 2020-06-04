package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
/* loaded from: classes.dex */
public class ab extends bk {
    public static final BdUniqueId lkZ = BdUniqueId.gen();
    private boolean fiz = false;
    private bm lla;
    private bp llb;

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return lkZ;
    }

    public boolean ddi() {
        return this.fiz;
    }

    public void up(boolean z) {
        this.fiz = z;
    }

    public bm ddj() {
        return this.lla;
    }

    public void a(bm bmVar) {
        this.lla = bmVar;
    }

    public bp ddk() {
        return this.llb;
    }

    public void a(bp bpVar) {
        this.llb = bpVar;
    }
}
