package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes.dex */
public class u extends bj {
    public static final BdUniqueId kfD = BdUniqueId.gen();
    private String fortune_desc;
    private boolean kfE;
    private o kfF;

    public boolean cKy() {
        return this.kfE;
    }

    public void sI(boolean z) {
        this.kfE = z;
    }

    public String cKz() {
        return this.fortune_desc;
    }

    public void IW(String str) {
        this.fortune_desc = str;
    }

    public o cKA() {
        return this.kfF;
    }

    public void a(o oVar) {
        this.kfF = oVar;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kfD;
    }
}
