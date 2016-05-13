package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ax;
/* loaded from: classes.dex */
public class aa extends ax {
    public static final BdUniqueId erz = BdUniqueId.gen();
    private boolean erA;
    private p erB;
    private String fortune_desc;

    public boolean aTe() {
        return this.erA;
    }

    public void jx(boolean z) {
        this.erA = z;
    }

    public String aTf() {
        return this.fortune_desc;
    }

    public void nQ(String str) {
        this.fortune_desc = str;
    }

    public p aTg() {
        return this.erB;
    }

    public void b(p pVar) {
        this.erB = pVar;
    }

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return erz;
    }
}
