package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes22.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kVU = BdUniqueId.gen();
    private bw akp;
    private AntiData eGx;
    private boolean kVV = false;
    public boolean kVW = false;

    public o(bw bwVar, AntiData antiData) {
        this.akp = bwVar;
        this.eGx = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kVU;
    }

    public int bjI() {
        if (this.akp != null) {
            return this.akp.bjI();
        }
        return 0;
    }

    public boolean dds() {
        return this.akp != null && this.akp.bjH() == 1;
    }

    public AntiData getAnti() {
        return this.eGx;
    }

    public bw bfG() {
        return this.akp;
    }

    public void ts(boolean z) {
        this.kVV = z;
    }

    public boolean ddt() {
        return this.kVV;
    }
}
