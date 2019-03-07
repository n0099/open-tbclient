package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId iFe = BdUniqueId.gen();
    private String fortune_desc;
    private boolean iFf;
    private m iFg;

    public boolean cdI() {
        return this.iFf;
    }

    public void pS(boolean z) {
        this.iFf = z;
    }

    public String cdJ() {
        return this.fortune_desc;
    }

    public void Ct(String str) {
        this.fortune_desc = str;
    }

    public m cdK() {
        return this.iFg;
    }

    public void a(m mVar) {
        this.iFg = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iFe;
    }
}
