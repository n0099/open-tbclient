package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class ab extends bj {
    public static final BdUniqueId kRw = BdUniqueId.gen();
    private boolean eVz = false;
    private bl kRx;
    private bo kRy;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kRw;
    }

    public boolean cVR() {
        return this.eVz;
    }

    public void tR(boolean z) {
        this.eVz = z;
    }

    public bl cVS() {
        return this.kRx;
    }

    public void a(bl blVar) {
        this.kRx = blVar;
    }

    public bo cVT() {
        return this.kRy;
    }

    public void a(bo boVar) {
        this.kRy = boVar;
    }
}
