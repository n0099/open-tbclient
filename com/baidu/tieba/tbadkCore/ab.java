package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.ca;
/* loaded from: classes.dex */
public class ab extends bv {
    public static final BdUniqueId lMk = BdUniqueId.gen();
    private boolean fyT = false;
    private bx lMl;
    private ca lMm;

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lMk;
    }

    public boolean dkH() {
        return this.fyT;
    }

    public void vi(boolean z) {
        this.fyT = z;
    }

    public bx dkI() {
        return this.lMl;
    }

    public void a(bx bxVar) {
        this.lMl = bxVar;
    }

    public ca dkJ() {
        return this.lMm;
    }

    public void a(ca caVar) {
        this.lMm = caVar;
    }
}
