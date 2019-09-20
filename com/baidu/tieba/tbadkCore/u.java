package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class u extends bh {
    public static final BdUniqueId jhv = BdUniqueId.gen();
    private String fortune_desc;
    private boolean jhw;
    private o jhx;

    public boolean cpR() {
        return this.jhw;
    }

    public void rb(boolean z) {
        this.jhw = z;
    }

    public String cpS() {
        return this.fortune_desc;
    }

    public void Fd(String str) {
        this.fortune_desc = str;
    }

    public o cpT() {
        return this.jhx;
    }

    public void a(o oVar) {
        this.jhx = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhv;
    }
}
