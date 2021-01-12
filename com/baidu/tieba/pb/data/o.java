package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes2.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lCJ = BdUniqueId.gen();
    private bz ale;
    private AntiData fgg;
    private boolean lCK = false;
    public boolean lCL = false;

    public o(bz bzVar, AntiData antiData) {
        this.ale = bzVar;
        this.fgg = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lCJ;
    }

    public int bpb() {
        if (this.ale != null) {
            return this.ale.bpb();
        }
        return 0;
    }

    public boolean djH() {
        return this.ale != null && this.ale.bpa() == 1;
    }

    public AntiData getAnti() {
        return this.fgg;
    }

    public bz bkV() {
        return this.ale;
    }

    public void uu(boolean z) {
        this.lCK = z;
    }

    public boolean djI() {
        return this.lCK;
    }
}
