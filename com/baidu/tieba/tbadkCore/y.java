package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class y extends bj {
    public static final BdUniqueId khp = BdUniqueId.gen();
    private boolean esd = false;
    private bl khq;
    private bo khr;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return khp;
    }

    public boolean cKV() {
        return this.esd;
    }

    public void sP(boolean z) {
        this.esd = z;
    }

    public bl cKW() {
        return this.khq;
    }

    public void a(bl blVar) {
        this.khq = blVar;
    }

    public bo cKX() {
        return this.khr;
    }

    public void a(bo boVar) {
        this.khr = boVar;
    }
}
