package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class u extends bj {
    public static final BdUniqueId kek = BdUniqueId.gen();
    private String fortune_desc;
    private boolean kel;
    private o kem;

    public boolean cIP() {
        return this.kel;
    }

    public void sE(boolean z) {
        this.kel = z;
    }

    public String cIQ() {
        return this.fortune_desc;
    }

    public void IH(String str) {
        this.fortune_desc = str;
    }

    public o cIR() {
        return this.kem;
    }

    public void a(o oVar) {
        this.kem = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kek;
    }
}
