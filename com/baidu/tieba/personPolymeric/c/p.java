package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cbf() {
        this.irp.clear();
        if (this.mCardNullPolymericData != null) {
            this.irp.add(this.mCardNullPolymericData);
        }
        if (!v.isEmpty(this.irr)) {
            this.irp.addAll(this.irr);
        }
        if (!v.isEmpty(this.iro)) {
            this.irp.addAll(this.iro);
        }
    }
}
