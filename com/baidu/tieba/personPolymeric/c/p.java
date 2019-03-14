package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bSj() {
        this.hRI.clear();
        if (this.mCardNullPolymericData != null) {
            this.hRI.add(this.mCardNullPolymericData);
        }
        if (!v.T(this.hRK)) {
            this.hRI.addAll(this.hRK);
        }
        if (!v.T(this.hRH)) {
            this.hRI.addAll(this.hRH);
        }
    }
}
