package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes16.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kiN = BdUniqueId.gen();
    private bv aii;
    private AntiData ein;
    private boolean kiO = false;
    public boolean kiP = false;

    public o(bv bvVar, AntiData antiData) {
        this.aii = bvVar;
        this.ein = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kiN;
    }

    public int aXM() {
        if (this.aii != null) {
            return this.aii.aXM();
        }
        return 0;
    }

    public boolean cLq() {
        return this.aii != null && this.aii.aXL() == 1;
    }

    public AntiData getAnti() {
        return this.ein;
    }

    public bv aTN() {
        return this.aii;
    }

    public void rV(boolean z) {
        this.kiO = z;
    }

    public boolean cLr() {
        return this.kiO;
    }
}
