package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes22.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lot = BdUniqueId.gen();
    private bw akq;
    private AntiData eUI;
    private boolean lou = false;
    public boolean lov = false;

    public o(bw bwVar, AntiData antiData) {
        this.akq = bwVar;
        this.eUI = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lot;
    }

    public int bob() {
        if (this.akq != null) {
            return this.akq.bob();
        }
        return 0;
    }

    public boolean djc() {
        return this.akq != null && this.akq.boa() == 1;
    }

    public AntiData getAnti() {
        return this.eUI;
    }

    public bw bjZ() {
        return this.akq;
    }

    public void tS(boolean z) {
        this.lou = z;
    }

    public boolean djd() {
        return this.lou;
    }
}
