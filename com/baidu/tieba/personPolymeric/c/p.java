package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.y;
/* loaded from: classes8.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dyJ() {
        this.mBx.clear();
        if (this.mCardNullPolymericData != null) {
            this.mBx.add(this.mCardNullPolymericData);
        }
        if (!y.isEmpty(this.mBw)) {
            this.mBx.addAll(this.mBw);
        }
    }
}
