package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.data.w {
    public static final BdUniqueId cYd = BdUniqueId.gen();
    private boolean cYe;
    private p cYf;
    private String fortune_desc;

    public boolean awc() {
        return this.cYe;
    }

    public void gs(boolean z) {
        this.cYe = z;
    }

    public String awd() {
        return this.fortune_desc;
    }

    public void ly(String str) {
        this.fortune_desc = str;
    }

    public p awe() {
        return this.cYf;
    }

    public void b(p pVar) {
        this.cYf = pVar;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return cYd;
    }
}
