package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class w extends bw {
    public static final BdUniqueId mPJ = BdUniqueId.gen();
    private String fortune_desc;
    private boolean mPK;
    private q mPL;

    public boolean dGT() {
        return this.mPK;
    }

    public void xf(boolean z) {
        this.mPK = z;
    }

    public String dGU() {
        return this.fortune_desc;
    }

    public void Ss(String str) {
        this.fortune_desc = str;
    }

    public q dGV() {
        return this.mPL;
    }

    public void a(q qVar) {
        this.mPL = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mPJ;
    }
}
