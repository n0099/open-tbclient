package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes.dex */
public class u extends bh {
    public static final BdUniqueId jfa = BdUniqueId.gen();
    private String fortune_desc;
    private boolean jfb;
    private o jfc;

    public boolean cpd() {
        return this.jfb;
    }

    public void qY(boolean z) {
        this.jfb = z;
    }

    public String cpe() {
        return this.fortune_desc;
    }

    public void ED(String str) {
        this.fortune_desc = str;
    }

    public o cpf() {
        return this.jfc;
    }

    public void a(o oVar) {
        this.jfc = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jfa;
    }
}
