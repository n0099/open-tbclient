package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class x extends cb {
    public static final BdUniqueId nxS = BdUniqueId.gen();
    private String fortune_desc;
    private boolean nxT;
    private r nxU;

    public boolean dNg() {
        return this.nxT;
    }

    public void yn(boolean z) {
        this.nxT = z;
    }

    public String dNh() {
        return this.fortune_desc;
    }

    public void To(String str) {
        this.fortune_desc = str;
    }

    public r dNi() {
        return this.nxU;
    }

    public void a(r rVar) {
        this.nxU = rVar;
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nxS;
    }
}
