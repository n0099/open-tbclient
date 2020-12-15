package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.by;
/* loaded from: classes.dex */
public class x extends by {
    public static final BdUniqueId nkF = BdUniqueId.gen();
    private String fortune_desc;
    private boolean nkG;
    private r nkH;

    public boolean dOE() {
        return this.nkG;
    }

    public void xW(boolean z) {
        this.nkG = z;
    }

    public String dOF() {
        return this.fortune_desc;
    }

    public void Ty(String str) {
        this.fortune_desc = str;
    }

    public r dOG() {
        return this.nkH;
    }

    public void a(r rVar) {
        this.nkH = rVar;
    }

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return nkF;
    }
}
