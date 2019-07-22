package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void ccZ() {
        this.iqD.clear();
        if (this.mCardNullPolymericData != null) {
            this.iqD.add(this.mCardNullPolymericData);
        }
        if (!v.aa(this.iqF)) {
            this.iqD.addAll(this.iqF);
        }
        if (!v.aa(this.iqC)) {
            this.iqD.addAll(this.iqC);
        }
    }
}
