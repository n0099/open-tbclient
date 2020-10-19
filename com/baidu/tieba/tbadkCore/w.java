package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class w extends bw {
    public static final BdUniqueId mDa = BdUniqueId.gen();
    private String fortune_desc;
    private boolean mDc;
    private q mDd;

    public boolean dDL() {
        return this.mDc;
    }

    public void wO(boolean z) {
        this.mDc = z;
    }

    public String dDM() {
        return this.fortune_desc;
    }

    public void RT(String str) {
        this.fortune_desc = str;
    }

    public q dDN() {
        return this.mDd;
    }

    public void a(q qVar) {
        this.mDd = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mDa;
    }
}
