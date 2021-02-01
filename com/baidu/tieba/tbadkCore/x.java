package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class x extends cb {
    public static final BdUniqueId nvo = BdUniqueId.gen();
    private String fortune_desc;
    private boolean nvp;
    private r nvq;

    public boolean dMQ() {
        return this.nvp;
    }

    public void yn(boolean z) {
        this.nvp = z;
    }

    public String dMR() {
        return this.fortune_desc;
    }

    public void SW(String str) {
        this.fortune_desc = str;
    }

    public r dMS() {
        return this.nvq;
    }

    public void a(r rVar) {
        this.nvq = rVar;
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nvo;
    }
}
