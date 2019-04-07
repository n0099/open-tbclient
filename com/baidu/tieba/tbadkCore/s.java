package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId iEH = BdUniqueId.gen();
    private String fortune_desc;
    private boolean iEI;
    private m iEJ;

    public boolean cdH() {
        return this.iEI;
    }

    public void pS(boolean z) {
        this.iEI = z;
    }

    public String cdI() {
        return this.fortune_desc;
    }

    public void Cr(String str) {
        this.fortune_desc = str;
    }

    public m cdJ() {
        return this.iEJ;
    }

    public void a(m mVar) {
        this.iEJ = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iEH;
    }
}
