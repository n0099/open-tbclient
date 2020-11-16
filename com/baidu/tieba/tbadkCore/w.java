package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
/* loaded from: classes.dex */
public class w extends bx {
    public static final BdUniqueId mWE = BdUniqueId.gen();
    private String fortune_desc;
    private boolean mWF;
    private q mWG;

    public boolean dJm() {
        return this.mWF;
    }

    public void xs(boolean z) {
        this.mWF = z;
    }

    public String dJn() {
        return this.fortune_desc;
    }

    public void Sk(String str) {
        this.fortune_desc = str;
    }

    public q dJo() {
        return this.mWG;
    }

    public void a(q qVar) {
        this.mWG = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bx, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mWE;
    }
}
