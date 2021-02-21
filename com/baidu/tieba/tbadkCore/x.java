package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class x extends cb {
    public static final BdUniqueId nvO = BdUniqueId.gen();
    private String fortune_desc;
    private boolean nvP;
    private r nvQ;

    public boolean dMY() {
        return this.nvP;
    }

    public void yn(boolean z) {
        this.nvP = z;
    }

    public String dMZ() {
        return this.fortune_desc;
    }

    public void Ti(String str) {
        this.fortune_desc = str;
    }

    public r dNa() {
        return this.nvQ;
    }

    public void a(r rVar) {
        this.nvQ = rVar;
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return nvO;
    }
}
