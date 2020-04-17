package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId joC = BdUniqueId.gen();
    private bj agz;
    private AntiData dGy;
    private boolean joD = false;
    public boolean joE = false;

    public k(bj bjVar, AntiData antiData) {
        this.agz = bjVar;
        this.dGy = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return joC;
    }

    public int aMc() {
        if (this.agz != null) {
            return this.agz.aMc();
        }
        return 0;
    }

    public boolean cwe() {
        return this.agz != null && this.agz.aMb() == 1;
    }

    public AntiData getAnti() {
        return this.dGy;
    }

    public bj aIw() {
        return this.agz;
    }

    public void qF(boolean z) {
        this.joD = z;
    }

    public boolean cwf() {
        return this.joD;
    }
}
