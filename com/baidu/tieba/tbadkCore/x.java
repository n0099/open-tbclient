package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class x extends bj {
    public static final BdUniqueId kaR = BdUniqueId.gen();
    private boolean emi = false;
    private bl kaS;
    private bo kaT;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kaR;
    }

    public boolean cHO() {
        return this.emi;
    }

    public void st(boolean z) {
        this.emi = z;
    }

    public bl cHP() {
        return this.kaS;
    }

    public void a(bl blVar) {
        this.kaS = blVar;
    }

    public bo cHQ() {
        return this.kaT;
    }

    public void a(bo boVar) {
        this.kaT = boVar;
    }
}
