package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class q extends a {
    public q(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void aZW() {
        this.foN.clear();
        if (this.foL != null) {
            this.foN.add(this.foL);
        } else if (this.foK != null) {
            this.foN.add(this.foK);
        } else if (this.mCardNullPolymericData != null) {
            this.foN.add(this.mCardNullPolymericData);
        }
        if (!v.v(this.foP)) {
            this.foN.addAll(this.foP);
        }
        if (!v.v(this.foM)) {
            this.foN.addAll(this.foM);
        }
    }
}
