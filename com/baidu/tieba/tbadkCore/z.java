package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.data.x {
    public static final BdUniqueId cQk = BdUniqueId.gen();
    private boolean cQl;
    private p cQm;
    private String fortune_desc;

    public boolean atE() {
        return this.cQl;
    }

    public void gh(boolean z) {
        this.cQl = z;
    }

    public String atF() {
        return this.fortune_desc;
    }

    public void kX(String str) {
        this.fortune_desc = str;
    }

    public p atG() {
        return this.cQm;
    }

    public void b(p pVar) {
        this.cQm = pVar;
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cQk;
    }
}
