package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class u extends bj {
    public static final BdUniqueId kfr = BdUniqueId.gen();
    private String fortune_desc;
    private boolean kfs;
    private o kft;

    public boolean cKx() {
        return this.kfs;
    }

    public void sI(boolean z) {
        this.kfs = z;
    }

    public String cKy() {
        return this.fortune_desc;
    }

    public void IV(String str) {
        this.fortune_desc = str;
    }

    public o cKz() {
        return this.kft;
    }

    public void a(o oVar) {
        this.kft = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kfr;
    }
}
