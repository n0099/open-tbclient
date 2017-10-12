package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class q extends a {
    public q(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void aWW() {
        this.fgD.clear();
        if (this.fgB != null) {
            this.fgD.add(this.fgB);
        } else if (this.fgA != null) {
            this.fgD.add(this.fgA);
        } else if (this.mCardNullPolymericData != null) {
            this.fgD.add(this.mCardNullPolymericData);
        }
        if (!v.u(this.fgF)) {
            this.fgD.addAll(this.fgF);
        }
        if (!v.u(this.fgC)) {
            this.fgD.addAll(this.fgC);
        }
    }
}
