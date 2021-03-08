package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.y;
/* loaded from: classes7.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dyS() {
        this.mDD.clear();
        if (this.mCardNullPolymericData != null) {
            this.mDD.add(this.mCardNullPolymericData);
        }
        if (!y.isEmpty(this.mDC)) {
            this.mDD.addAll(this.mDC);
        }
    }
}
