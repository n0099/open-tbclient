package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class v extends bj {
    public static final BdUniqueId kRo = BdUniqueId.gen();
    private String fortune_desc;
    private boolean kRp;
    private p kRq;

    public boolean cVM() {
        return this.kRp;
    }

    public void tQ(boolean z) {
        this.kRp = z;
    }

    public String cVN() {
        return this.fortune_desc;
    }

    public void KI(String str) {
        this.fortune_desc = str;
    }

    public p cVO() {
        return this.kRq;
    }

    public void a(p pVar) {
        this.kRq = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kRo;
    }
}
