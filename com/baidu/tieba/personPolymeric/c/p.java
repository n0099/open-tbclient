package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.y;
/* loaded from: classes24.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dta() {
        this.lXa.clear();
        if (this.mCardNullPolymericData != null) {
            this.lXa.add(this.mCardNullPolymericData);
        }
        if (!y.isEmpty(this.lWZ)) {
            this.lXa.addAll(this.lWZ);
        }
    }
}
