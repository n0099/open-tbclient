package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class u extends bh {
    public static final BdUniqueId jhl = BdUniqueId.gen();
    private String fortune_desc;
    private boolean jhm;
    private o jhn;

    public boolean cnI() {
        return this.jhm;
    }

    public void qK(boolean z) {
        this.jhm = z;
    }

    public String cnJ() {
        return this.fortune_desc;
    }

    public void DI(String str) {
        this.fortune_desc = str;
    }

    public o cnK() {
        return this.jhn;
    }

    public void a(o oVar) {
        this.jhn = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhl;
    }
}
