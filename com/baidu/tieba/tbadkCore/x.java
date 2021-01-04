package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class x extends bz {
    public static final BdUniqueId nqn = BdUniqueId.gen();
    private String fortune_desc;
    private boolean nqo;
    private r nqp;

    public boolean dOw() {
        return this.nqo;
    }

    public void xY(boolean z) {
        this.nqo = z;
    }

    public String dOx() {
        return this.fortune_desc;
    }

    public void Th(String str) {
        this.fortune_desc = str;
    }

    public r dOy() {
        return this.nqp;
    }

    public void a(r rVar) {
        this.nqp = rVar;
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nqn;
    }
}
