package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
/* loaded from: classes.dex */
public class ab extends bk {
    public static final BdUniqueId ljQ = BdUniqueId.gen();
    private boolean fin = false;
    private bm ljR;
    private bp ljS;

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ljQ;
    }

    public boolean dcT() {
        return this.fin;
    }

    public void up(boolean z) {
        this.fin = z;
    }

    public bm dcU() {
        return this.ljR;
    }

    public void a(bm bmVar) {
        this.ljR = bmVar;
    }

    public bp dcV() {
        return this.ljS;
    }

    public void a(bp bpVar) {
        this.ljS = bpVar;
    }
}
