package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes2.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lLM = BdUniqueId.gen();
    private cb akU;
    private AntiData fiz;
    private boolean lLN = false;
    public boolean lLO = false;
    private boolean lLP = false;

    public p(cb cbVar, AntiData antiData) {
        this.akU = cbVar;
        this.fiz = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lLM;
    }

    public int bpt() {
        if (this.akU != null) {
            return this.akU.bpt();
        }
        return 0;
    }

    public boolean dma() {
        return this.akU != null && this.akU.bps() == 1;
    }

    public AntiData getAnti() {
        return this.fiz;
    }

    public cb bln() {
        return this.akU;
    }

    public void uH(boolean z) {
        this.lLN = z;
    }

    public boolean dmb() {
        return this.lLN;
    }

    public boolean dmc() {
        return this.lLP;
    }

    public void uI(boolean z) {
        this.lLP = z;
    }
}
