package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bSf() {
        this.hRv.clear();
        if (this.mCardNullPolymericData != null) {
            this.hRv.add(this.mCardNullPolymericData);
        }
        if (!v.T(this.hRx)) {
            this.hRv.addAll(this.hRx);
        }
        if (!v.T(this.hRu)) {
            this.hRv.addAll(this.hRu);
        }
    }
}
