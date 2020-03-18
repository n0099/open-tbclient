package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iEw = BdUniqueId.gen();
    private bj NR;
    private AntiData dhb;
    private boolean iEx = false;
    public boolean iEy = false;

    public k(bj bjVar, AntiData antiData) {
        this.NR = bjVar;
        this.dhb = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iEw;
    }

    public int aDO() {
        if (this.NR != null) {
            return this.NR.aDO();
        }
        return 0;
    }

    public boolean cly() {
        return this.NR != null && this.NR.aDN() == 1;
    }

    public AntiData getAnti() {
        return this.dhb;
    }

    public bj aAj() {
        return this.NR;
    }

    public void pB(boolean z) {
        this.iEx = z;
    }

    public boolean clz() {
        return this.iEx;
    }
}
