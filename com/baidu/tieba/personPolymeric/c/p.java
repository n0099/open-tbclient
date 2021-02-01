package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.y;
/* loaded from: classes8.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dyC() {
        this.mBi.clear();
        if (this.mCardNullPolymericData != null) {
            this.mBi.add(this.mCardNullPolymericData);
        }
        if (!y.isEmpty(this.mBh)) {
            this.mBi.addAll(this.mBh);
        }
    }
}
