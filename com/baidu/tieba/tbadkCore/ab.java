package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
/* loaded from: classes.dex */
public class ab extends be {
    public static final BdUniqueId fjp = BdUniqueId.gen();
    private boolean fjq;
    private q fjr;
    private String fortune_desc;

    public boolean beG() {
        return this.fjq;
    }

    public void kw(boolean z) {
        this.fjq = z;
    }

    public String beH() {
        return this.fortune_desc;
    }

    public void qi(String str) {
        this.fortune_desc = str;
    }

    public q beI() {
        return this.fjr;
    }

    public void b(q qVar) {
        this.fjr = qVar;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fjp;
    }
}
