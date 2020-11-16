package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bx;
/* loaded from: classes21.dex */
public class o implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId loL = BdUniqueId.gen();
    private bx akt;
    private AntiData eTQ;
    private boolean loM = false;
    public boolean loN = false;

    public o(bx bxVar, AntiData antiData) {
        this.akt = bxVar;
        this.eTQ = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return loL;
    }

    public int bnf() {
        if (this.akt != null) {
            return this.akt.bnf();
        }
        return 0;
    }

    public boolean diz() {
        return this.akt != null && this.akt.bne() == 1;
    }

    public AntiData getAnti() {
        return this.eTQ;
    }

    public bx bjd() {
        return this.akt;
    }

    public void tV(boolean z) {
        this.loM = z;
    }

    public boolean diA() {
        return this.loM;
    }
}
