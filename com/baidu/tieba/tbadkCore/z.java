package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.data.ah {
    public static final BdUniqueId dVD = BdUniqueId.gen();
    private boolean dVE;
    private p dVF;
    private String fortune_desc;

    public boolean aLF() {
        return this.dVE;
    }

    public void hT(boolean z) {
        this.dVE = z;
    }

    public String aLG() {
        return this.fortune_desc;
    }

    public void mG(String str) {
        this.fortune_desc = str;
    }

    public p aLH() {
        return this.dVF;
    }

    public void b(p pVar) {
        this.dVF = pVar;
    }

    @Override // com.baidu.tbadk.core.data.ah, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dVD;
    }
}
