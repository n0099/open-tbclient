package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bks() {
        this.gps.clear();
        if (this.mCardNullPolymericData != null) {
            this.gps.add(this.mCardNullPolymericData);
        }
        if (!v.E(this.gpu)) {
            this.gps.addAll(this.gpu);
        }
        if (!v.E(this.gpr)) {
            this.gps.addAll(this.gpr);
        }
    }
}
