package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ag extends com.baidu.tbadk.core.data.x {
    public static final BdUniqueId bUU = BdUniqueId.gen();
    private boolean bTD;
    private u bTE;
    private String fortune_desc;

    public boolean afb() {
        return this.bTD;
    }

    public void ex(boolean z) {
        this.bTD = z;
    }

    public String afc() {
        return this.fortune_desc;
    }

    public void ie(String str) {
        this.fortune_desc = str;
    }

    public u afd() {
        return this.bTE;
    }

    public void a(u uVar) {
        this.bTE = uVar;
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.am
    public BdUniqueId jl() {
        return bUU;
    }
}
