package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId iFf = BdUniqueId.gen();
    private String fortune_desc;
    private boolean iFg;
    private m iFh;

    public boolean cdJ() {
        return this.iFg;
    }

    public void pS(boolean z) {
        this.iFg = z;
    }

    public String cdK() {
        return this.fortune_desc;
    }

    public void Cu(String str) {
        this.fortune_desc = str;
    }

    public m cdL() {
        return this.iFh;
    }

    public void a(m mVar) {
        this.iFh = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iFf;
    }
}
