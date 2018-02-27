package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bkr() {
        this.gph.clear();
        if (this.mCardNullPolymericData != null) {
            this.gph.add(this.mCardNullPolymericData);
        }
        if (!v.E(this.gpj)) {
            this.gph.addAll(this.gpj);
        }
        if (!v.E(this.gpg)) {
            this.gph.addAll(this.gpg);
        }
    }
}
