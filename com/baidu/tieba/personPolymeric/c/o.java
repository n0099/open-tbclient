package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class o extends a {
    public o(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void Xn() {
        this.fld.clear();
        if (this.flb != null) {
            this.fld.add(this.flb);
        }
        if (this.mCardNullPolymericData != null && this.flb == null) {
            this.fld.add(this.mCardNullPolymericData);
        }
        if (!v.v(this.flf)) {
            this.fld.addAll(this.flf);
        }
        if (!v.v(this.flc)) {
            this.fld.addAll(this.flc);
        }
    }
}
