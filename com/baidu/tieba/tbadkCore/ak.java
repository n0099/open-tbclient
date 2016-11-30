package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.br;
/* loaded from: classes.dex */
public class ak extends bk {
    public static final BdUniqueId fBq = BdUniqueId.gen();
    private bo fBr;
    private br fBs;
    private boolean fBt = false;

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fBq;
    }

    public boolean blz() {
        return this.fBt;
    }

    public void lk(boolean z) {
        this.fBt = z;
    }

    public bo blA() {
        return this.fBr;
    }

    public void a(bo boVar) {
        this.fBr = boVar;
    }

    public br blB() {
        return this.fBs;
    }

    public void a(br brVar) {
        this.fBs = brVar;
    }
}
