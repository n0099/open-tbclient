package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes.dex */
public class s extends bg {
    public static final BdUniqueId iEX = BdUniqueId.gen();
    private String fortune_desc;
    private boolean iEY;
    private m iEZ;

    public boolean cdL() {
        return this.iEY;
    }

    public void pS(boolean z) {
        this.iEY = z;
    }

    public String cdM() {
        return this.fortune_desc;
    }

    public void Cs(String str) {
        this.fortune_desc = str;
    }

    public m cdN() {
        return this.iEZ;
    }

    public void a(m mVar) {
        this.iEZ = mVar;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iEX;
    }
}
