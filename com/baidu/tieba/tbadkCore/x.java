package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class x extends bj {
    public static final BdUniqueId kfB = BdUniqueId.gen();
    private boolean eru = false;
    private bl kfC;
    private bo kfD;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kfB;
    }

    public boolean cKA() {
        return this.eru;
    }

    public void sJ(boolean z) {
        this.eru = z;
    }

    public bl cKB() {
        return this.kfC;
    }

    public void a(bl blVar) {
        this.kfC = blVar;
    }

    public bo cKC() {
        return this.kfD;
    }

    public void a(bo boVar) {
        this.kfD = boVar;
    }
}
