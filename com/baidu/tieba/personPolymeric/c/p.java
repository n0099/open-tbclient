package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void caj() {
        this.ikk.clear();
        if (this.mCardNullPolymericData != null) {
            this.ikk.add(this.mCardNullPolymericData);
        }
        if (!v.aa(this.ikm)) {
            this.ikk.addAll(this.ikm);
        }
        if (!v.aa(this.ikj)) {
            this.ikk.addAll(this.ikj);
        }
    }
}
