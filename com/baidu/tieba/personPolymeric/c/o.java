package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
public class o extends a {
    public o(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void UT() {
        this.eWi.clear();
        if (this.eWg != null) {
            this.eWi.add(this.eWg);
        }
        if (this.mCardNullPolymericData != null && this.eWg == null) {
            this.eWi.add(this.mCardNullPolymericData);
        }
        if (!z.t(this.eWh)) {
            this.eWi.addAll(this.eWh);
        }
    }
}
