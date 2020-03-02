package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iCJ = BdUniqueId.gen();
    private bj NQ;
    private AntiData dgB;
    private boolean iCK = false;
    public boolean iCL = false;

    public k(bj bjVar, AntiData antiData) {
        this.NQ = bjVar;
        this.dgB = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iCJ;
    }

    public int aDK() {
        if (this.NQ != null) {
            return this.NQ.aDK();
        }
        return 0;
    }

    public boolean clc() {
        return this.NQ != null && this.NQ.aDJ() == 1;
    }

    public AntiData getAnti() {
        return this.dgB;
    }

    public bj aAg() {
        return this.NQ;
    }

    public void pv(boolean z) {
        this.iCK = z;
    }

    public boolean cld() {
        return this.iCK;
    }
}
