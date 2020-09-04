package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes16.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kym = BdUniqueId.gen();
    private bw ajz;
    private AntiData esi;
    private boolean kyn = false;
    public boolean kyo = false;

    public o(bw bwVar, AntiData antiData) {
        this.ajz = bwVar;
        this.esi = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kym;
    }

    public int bgf() {
        if (this.ajz != null) {
            return this.ajz.bgf();
        }
        return 0;
    }

    public boolean cWf() {
        return this.ajz != null && this.ajz.bge() == 1;
    }

    public AntiData getAnti() {
        return this.esi;
    }

    public bw bce() {
        return this.ajz;
    }

    public void sE(boolean z) {
        this.kyn = z;
    }

    public boolean cWg() {
        return this.kyn;
    }
}
