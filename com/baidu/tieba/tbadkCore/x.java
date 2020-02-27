package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
/* loaded from: classes.dex */
public class x extends bj {
    public static final BdUniqueId kfz = BdUniqueId.gen();
    private boolean ert = false;
    private bl kfA;
    private bo kfB;

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kfz;
    }

    public boolean cKy() {
        return this.ert;
    }

    public void sJ(boolean z) {
        this.ert = z;
    }

    public bl cKz() {
        return this.kfA;
    }

    public void a(bl blVar) {
        this.kfA = blVar;
    }

    public bo cKA() {
        return this.kfB;
    }

    public void a(bo boVar) {
        this.kfB = boVar;
    }
}
