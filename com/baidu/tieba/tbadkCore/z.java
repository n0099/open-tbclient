package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.data.w {
    public static final BdUniqueId cZA = BdUniqueId.gen();
    private boolean cZB;
    private p cZC;
    private String fortune_desc;

    public boolean awG() {
        return this.cZB;
    }

    public void gv(boolean z) {
        this.cZB = z;
    }

    public String awH() {
        return this.fortune_desc;
    }

    public void lC(String str) {
        this.fortune_desc = str;
    }

    public p awI() {
        return this.cZC;
    }

    public void b(p pVar) {
        this.cZC = pVar;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cZA;
    }
}
