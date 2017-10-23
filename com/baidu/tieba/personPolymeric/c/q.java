package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class q extends a {
    public q(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void aWR() {
        this.fgp.clear();
        if (this.fgn != null) {
            this.fgp.add(this.fgn);
        } else if (this.fgm != null) {
            this.fgp.add(this.fgm);
        } else if (this.mCardNullPolymericData != null) {
            this.fgp.add(this.mCardNullPolymericData);
        }
        if (!v.u(this.fgr)) {
            this.fgp.addAll(this.fgr);
        }
        if (!v.u(this.fgo)) {
            this.fgp.addAll(this.fgo);
        }
    }
}
