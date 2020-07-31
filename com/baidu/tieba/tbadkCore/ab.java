package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.ca;
/* loaded from: classes.dex */
public class ab extends bv {
    public static final BdUniqueId lMi = BdUniqueId.gen();
    private boolean fyT = false;
    private bx lMj;
    private ca lMk;

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lMi;
    }

    public boolean dkG() {
        return this.fyT;
    }

    public void vi(boolean z) {
        this.fyT = z;
    }

    public bx dkH() {
        return this.lMj;
    }

    public void a(bx bxVar) {
        this.lMj = bxVar;
    }

    public ca dkI() {
        return this.lMk;
    }

    public void a(ca caVar) {
        this.lMk = caVar;
    }
}
