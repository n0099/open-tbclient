package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class u extends bj {
    public static final BdUniqueId kep = BdUniqueId.gen();
    private String fortune_desc;
    private boolean keq;
    private o ker;

    public boolean cIR() {
        return this.keq;
    }

    public void sE(boolean z) {
        this.keq = z;
    }

    public String cIS() {
        return this.fortune_desc;
    }

    public void IH(String str) {
        this.fortune_desc = str;
    }

    public o cIT() {
        return this.ker;
    }

    public void a(o oVar) {
        this.ker = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kep;
    }
}
