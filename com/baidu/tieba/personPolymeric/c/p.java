package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cdr() {
        this.irH.clear();
        if (this.mCardNullPolymericData != null) {
            this.irH.add(this.mCardNullPolymericData);
        }
        if (!v.aa(this.irJ)) {
            this.irH.addAll(this.irJ);
        }
        if (!v.aa(this.irG)) {
            this.irH.addAll(this.irG);
        }
    }
}
