package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class x extends bz {
    public static final BdUniqueId nqm = BdUniqueId.gen();
    private String fortune_desc;
    private boolean nqn;
    private r nqo;

    public boolean dOx() {
        return this.nqn;
    }

    public void xY(boolean z) {
        this.nqn = z;
    }

    public String dOy() {
        return this.fortune_desc;
    }

    public void Tg(String str) {
        this.fortune_desc = str;
    }

    public r dOz() {
        return this.nqo;
    }

    public void a(r rVar) {
        this.nqo = rVar;
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nqm;
    }
}
