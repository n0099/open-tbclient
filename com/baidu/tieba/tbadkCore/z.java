package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.as;
/* loaded from: classes.dex */
public class z extends as {
    public static final BdUniqueId eoi = BdUniqueId.gen();
    private boolean eoj;
    private p eok;
    private String fortune_desc;

    public boolean aSz() {
        return this.eoj;
    }

    public void iI(boolean z) {
        this.eoj = z;
    }

    public String aSA() {
        return this.fortune_desc;
    }

    public void nR(String str) {
        this.fortune_desc = str;
    }

    public p aSB() {
        return this.eok;
    }

    public void b(p pVar) {
        this.eok = pVar;
    }

    @Override // com.baidu.tbadk.core.data.as, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return eoi;
    }
}
