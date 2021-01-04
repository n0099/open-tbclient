package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes2.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lHp = BdUniqueId.gen();
    private bz alW;
    private AntiData fkR;
    private boolean lHq = false;
    public boolean lHr = false;

    public o(bz bzVar, AntiData antiData) {
        this.alW = bzVar;
        this.fkR = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lHp;
    }

    public int bsU() {
        if (this.alW != null) {
            return this.alW.bsU();
        }
        return 0;
    }

    public boolean dnz() {
        return this.alW != null && this.alW.bsT() == 1;
    }

    public AntiData getAnti() {
        return this.fkR;
    }

    public bz boO() {
        return this.alW;
    }

    public void uy(boolean z) {
        this.lHq = z;
    }

    public boolean dnA() {
        return this.lHq;
    }
}
