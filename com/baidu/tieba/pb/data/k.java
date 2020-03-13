package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iCV = BdUniqueId.gen();
    private bj NQ;
    private AntiData dgO;
    private boolean iCW = false;
    public boolean iCX = false;

    public k(bj bjVar, AntiData antiData) {
        this.NQ = bjVar;
        this.dgO = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iCV;
    }

    public int aDK() {
        if (this.NQ != null) {
            return this.NQ.aDK();
        }
        return 0;
    }

    public boolean cld() {
        return this.NQ != null && this.NQ.aDJ() == 1;
    }

    public AntiData getAnti() {
        return this.dgO;
    }

    public bj aAg() {
        return this.NQ;
    }

    public void pv(boolean z) {
        this.iCW = z;
    }

    public boolean cle() {
        return this.iCW;
    }
}
