package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
/* loaded from: classes.dex */
public class x extends by {
    public static final BdUniqueId nkD = BdUniqueId.gen();
    private String fortune_desc;
    private boolean nkE;
    private r nkF;

    public boolean dOD() {
        return this.nkE;
    }

    public void xW(boolean z) {
        this.nkE = z;
    }

    public String dOE() {
        return this.fortune_desc;
    }

    public void Ty(String str) {
        this.fortune_desc = str;
    }

    public r dOF() {
        return this.nkF;
    }

    public void a(r rVar) {
        this.nkF = rVar;
    }

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return nkD;
    }
}
