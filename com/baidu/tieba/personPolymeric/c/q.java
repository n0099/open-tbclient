package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class q extends a {
    public q(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void aWX() {
        this.fgE.clear();
        if (this.fgC != null) {
            this.fgE.add(this.fgC);
        } else if (this.fgB != null) {
            this.fgE.add(this.fgB);
        } else if (this.mCardNullPolymericData != null) {
            this.fgE.add(this.mCardNullPolymericData);
        }
        if (!v.u(this.fgG)) {
            this.fgE.addAll(this.fgG);
        }
        if (!v.u(this.fgD)) {
            this.fgE.addAll(this.fgD);
        }
    }
}
