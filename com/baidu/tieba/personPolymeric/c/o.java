package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class o extends a {
    public o(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void Xc() {
        this.fkk.clear();
        if (this.fki != null) {
            this.fkk.add(this.fki);
        }
        if (this.mCardNullPolymericData != null && this.fki == null) {
            this.fkk.add(this.mCardNullPolymericData);
        }
        if (!v.v(this.fkm)) {
            this.fkk.addAll(this.fkm);
        }
        if (!v.v(this.fkj)) {
            this.fkk.addAll(this.fkj);
        }
    }
}
