package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bqr() {
        this.gxN.clear();
        if (this.mCardNullPolymericData != null) {
            this.gxN.add(this.mCardNullPolymericData);
        }
        if (!v.I(this.gxP)) {
            this.gxN.addAll(this.gxP);
        }
        if (!v.I(this.gxM)) {
            this.gxN.addAll(this.gxM);
        }
    }
}
