package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class w extends bw {
    public static final BdUniqueId mVM = BdUniqueId.gen();
    private String fortune_desc;
    private boolean mVN;
    private q mVO;

    public boolean dJv() {
        return this.mVN;
    }

    public void xo(boolean z) {
        this.mVN = z;
    }

    public String dJw() {
        return this.fortune_desc;
    }

    public void SJ(String str) {
        this.fortune_desc = str;
    }

    public q dJx() {
        return this.mVO;
    }

    public void a(q qVar) {
        this.mVO = qVar;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mVM;
    }
}
