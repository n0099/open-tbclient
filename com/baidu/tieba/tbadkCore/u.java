package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class u extends bj {
    public static final BdUniqueId kaH = BdUniqueId.gen();
    private String fortune_desc;
    private boolean kaI;
    private o kaJ;

    public boolean cHL() {
        return this.kaI;
    }

    public void ss(boolean z) {
        this.kaI = z;
    }

    public String cHM() {
        return this.fortune_desc;
    }

    public void Ix(String str) {
        this.fortune_desc = str;
    }

    public o cHN() {
        return this.kaJ;
    }

    public void a(o oVar) {
        this.kaJ = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kaH;
    }
}
