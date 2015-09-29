package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.data.v {
    public static final BdUniqueId cXD = BdUniqueId.gen();
    private boolean cXE;
    private p cXF;
    private String fortune_desc;

    public boolean avU() {
        return this.cXE;
    }

    public void gs(boolean z) {
        this.cXE = z;
    }

    public String avV() {
        return this.fortune_desc;
    }

    public void lv(String str) {
        this.fortune_desc = str;
    }

    public p avW() {
        return this.cXF;
    }

    public void b(p pVar) {
        this.cXF = pVar;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cXD;
    }
}
