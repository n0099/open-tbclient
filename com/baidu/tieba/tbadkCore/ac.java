package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.cc;
/* loaded from: classes.dex */
public class ac extends bx {
    public static final BdUniqueId mWR = BdUniqueId.gen();
    private boolean gpt = false;
    private bz mWS;
    private cc mWT;

    @Override // com.baidu.tbadk.core.data.bx, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mWR;
    }

    public boolean dJp() {
        return this.gpt;
    }

    public void xt(boolean z) {
        this.gpt = z;
    }

    public bz dJq() {
        return this.mWS;
    }

    public void a(bz bzVar) {
        this.mWS = bzVar;
    }

    public cc dJr() {
        return this.mWT;
    }

    public void a(cc ccVar) {
        this.mWT = ccVar;
    }
}
