package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes9.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kaf = BdUniqueId.gen();
    private bu aiq;
    private AntiData ecd;
    private boolean kag = false;
    public boolean kah = false;

    public m(bu buVar, AntiData antiData) {
        this.aiq = buVar;
        this.ecd = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kaf;
    }

    public int aTQ() {
        if (this.aiq != null) {
            return this.aiq.aTQ();
        }
        return 0;
    }

    public boolean cHF() {
        return this.aiq != null && this.aiq.aTP() == 1;
    }

    public AntiData getAnti() {
        return this.ecd;
    }

    public bu aPS() {
        return this.aiq;
    }

    public void rq(boolean z) {
        this.kag = z;
    }

    public boolean cHG() {
        return this.kag;
    }
}
