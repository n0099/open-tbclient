package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes2.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lHo = BdUniqueId.gen();
    private bz alW;
    private AntiData fkR;
    private boolean lHp = false;
    public boolean lHq = false;

    public o(bz bzVar, AntiData antiData) {
        this.alW = bzVar;
        this.fkR = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lHo;
    }

    public int bsV() {
        if (this.alW != null) {
            return this.alW.bsV();
        }
        return 0;
    }

    public boolean dnA() {
        return this.alW != null && this.alW.bsU() == 1;
    }

    public AntiData getAnti() {
        return this.fkR;
    }

    public bz boP() {
        return this.alW;
    }

    public void uy(boolean z) {
        this.lHp = z;
    }

    public boolean dnB() {
        return this.lHp;
    }
}
