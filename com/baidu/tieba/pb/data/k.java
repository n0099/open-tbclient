package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iCH = BdUniqueId.gen();
    private bj NQ;
    private AntiData dgA;
    private boolean iCI = false;
    public boolean iCJ = false;

    public k(bj bjVar, AntiData antiData) {
        this.NQ = bjVar;
        this.dgA = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iCH;
    }

    public int aDI() {
        if (this.NQ != null) {
            return this.NQ.aDI();
        }
        return 0;
    }

    public boolean cla() {
        return this.NQ != null && this.NQ.aDH() == 1;
    }

    public AntiData getAnti() {
        return this.dgA;
    }

    public bj aAe() {
        return this.NQ;
    }

    public void pv(boolean z) {
        this.iCI = z;
    }

    public boolean clb() {
        return this.iCI;
    }
}
