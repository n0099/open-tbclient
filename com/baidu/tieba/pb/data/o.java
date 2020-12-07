package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.by;
/* loaded from: classes22.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lCh = BdUniqueId.gen();
    private by alu;
    private AntiData fbn;
    private boolean lCi = false;
    public boolean lCj = false;

    public o(by byVar, AntiData antiData) {
        this.alu = byVar;
        this.fbn = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lCh;
    }

    public int bqs() {
        if (this.alu != null) {
            return this.alu.bqs();
        }
        return 0;
    }

    public boolean dnO() {
        return this.alu != null && this.alu.bqr() == 1;
    }

    public AntiData getAnti() {
        return this.fbn;
    }

    public by bmn() {
        return this.alu;
    }

    public void ux(boolean z) {
        this.lCi = z;
    }

    public boolean dnP() {
        return this.lCi;
    }
}
