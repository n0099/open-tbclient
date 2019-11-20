package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class u extends bh {
    public static final BdUniqueId jgu = BdUniqueId.gen();
    private String fortune_desc;
    private boolean jgv;
    private o jgw;

    public boolean cnG() {
        return this.jgv;
    }

    public void qK(boolean z) {
        this.jgv = z;
    }

    public String cnH() {
        return this.fortune_desc;
    }

    public void DI(String str) {
        this.fortune_desc = str;
    }

    public o cnI() {
        return this.jgw;
    }

    public void a(o oVar) {
        this.jgw = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgu;
    }
}
