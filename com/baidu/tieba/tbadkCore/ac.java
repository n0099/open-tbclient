package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class ac extends bw {
    public static final BdUniqueId mPV = BdUniqueId.gen();
    private boolean gjZ = false;
    private by mPW;
    private cb mPX;

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mPV;
    }

    public boolean dGW() {
        return this.gjZ;
    }

    public void xg(boolean z) {
        this.gjZ = z;
    }

    public by dGX() {
        return this.mPW;
    }

    public void a(by byVar) {
        this.mPW = byVar;
    }

    public cb dGY() {
        return this.mPX;
    }

    public void a(cb cbVar) {
        this.mPX = cbVar;
    }
}
