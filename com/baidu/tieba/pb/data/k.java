package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId joG = BdUniqueId.gen();
    private bj agC;
    private AntiData dGC;
    private boolean joH = false;
    public boolean joI = false;

    public k(bj bjVar, AntiData antiData) {
        this.agC = bjVar;
        this.dGC = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return joG;
    }

    public int aMa() {
        if (this.agC != null) {
            return this.agC.aMa();
        }
        return 0;
    }

    public boolean cwc() {
        return this.agC != null && this.agC.aLZ() == 1;
    }

    public AntiData getAnti() {
        return this.dGC;
    }

    public bj aIu() {
        return this.agC;
    }

    public void qF(boolean z) {
        this.joH = z;
    }

    public boolean cwd() {
        return this.joH;
    }
}
