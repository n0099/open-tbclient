package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class v extends bj {
    public static final BdUniqueId kRk = BdUniqueId.gen();
    private String fortune_desc;
    private boolean kRl;
    private p kRm;

    public boolean cVO() {
        return this.kRl;
    }

    public void tQ(boolean z) {
        this.kRl = z;
    }

    public String cVP() {
        return this.fortune_desc;
    }

    public void KF(String str) {
        this.fortune_desc = str;
    }

    public p cVQ() {
        return this.kRm;
    }

    public void a(p pVar) {
        this.kRm = pVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kRk;
    }
}
