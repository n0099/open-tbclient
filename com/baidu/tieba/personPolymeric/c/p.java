package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cak() {
        this.ikl.clear();
        if (this.mCardNullPolymericData != null) {
            this.ikl.add(this.mCardNullPolymericData);
        }
        if (!v.aa(this.ikn)) {
            this.ikl.addAll(this.ikn);
        }
        if (!v.aa(this.ikk)) {
            this.ikl.addAll(this.ikk);
        }
    }
}
