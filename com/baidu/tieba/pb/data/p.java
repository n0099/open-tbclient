package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes2.dex */
public class p implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lNO = BdUniqueId.gen();
    private cb amn;
    private AntiData fjY;
    private boolean lNP = false;
    public boolean lNQ = false;
    private boolean lNR = false;

    public p(cb cbVar, AntiData antiData) {
        this.amn = cbVar;
        this.fjY = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lNO;
    }

    public int bpv() {
        if (this.amn != null) {
            return this.amn.bpv();
        }
        return 0;
    }

    public boolean dmj() {
        return this.amn != null && this.amn.bpu() == 1;
    }

    public AntiData getAnti() {
        return this.fjY;
    }

    public cb blp() {
        return this.amn;
    }

    public void uH(boolean z) {
        this.lNP = z;
    }

    public boolean dmk() {
        return this.lNP;
    }

    public boolean dml() {
        return this.lNR;
    }

    public void uI(boolean z) {
        this.lNR = z;
    }
}
