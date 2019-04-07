package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bSf() {
        this.hRu.clear();
        if (this.mCardNullPolymericData != null) {
            this.hRu.add(this.mCardNullPolymericData);
        }
        if (!v.T(this.hRw)) {
            this.hRu.addAll(this.hRw);
        }
        if (!v.T(this.hRt)) {
            this.hRu.addAll(this.hRt);
        }
    }
}
