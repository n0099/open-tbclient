package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes.dex */
public class aa extends bk {
    public static final BdUniqueId fBc = BdUniqueId.gen();
    private boolean fBd;
    private q fBe;
    private String fortune_desc;

    public boolean blw() {
        return this.fBd;
    }

    public void lj(boolean z) {
        this.fBd = z;
    }

    public String blx() {
        return this.fortune_desc;
    }

    public void rB(String str) {
        this.fortune_desc = str;
    }

    public q bly() {
        return this.fBe;
    }

    public void b(q qVar) {
        this.fBe = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return fBc;
    }
}
