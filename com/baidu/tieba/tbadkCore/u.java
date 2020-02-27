package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class u extends bj {
    public static final BdUniqueId kfp = BdUniqueId.gen();
    private String fortune_desc;
    private boolean kfq;
    private o kfr;

    public boolean cKv() {
        return this.kfq;
    }

    public void sI(boolean z) {
        this.kfq = z;
    }

    public String cKw() {
        return this.fortune_desc;
    }

    public void IV(String str) {
        this.fortune_desc = str;
    }

    public o cKx() {
        return this.kfr;
    }

    public void a(o oVar) {
        this.kfr = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kfp;
    }
}
