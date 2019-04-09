package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId iEI = BdUniqueId.gen();
    private String fortune_desc;
    private boolean iEJ;
    private m iEK;

    public boolean cdH() {
        return this.iEJ;
    }

    public void pS(boolean z) {
        this.iEJ = z;
    }

    public String cdI() {
        return this.fortune_desc;
    }

    public void Cr(String str) {
        this.fortune_desc = str;
    }

    public m cdJ() {
        return this.iEK;
    }

    public void a(m mVar) {
        this.iEK = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iEI;
    }
}
