package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class ab extends bj {
    public static final BdUniqueId kRA = BdUniqueId.gen();
    private boolean eVE = false;
    private bl kRB;
    private bo kRC;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kRA;
    }

    public boolean cVP() {
        return this.eVE;
    }

    public void tR(boolean z) {
        this.eVE = z;
    }

    public bl cVQ() {
        return this.kRB;
    }

    public void a(bl blVar) {
        this.kRB = blVar;
    }

    public bo cVR() {
        return this.kRC;
    }

    public void a(bo boVar) {
        this.kRC = boVar;
    }
}
