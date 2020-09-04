package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.y;
/* loaded from: classes18.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void diE() {
        this.lmv.clear();
        if (this.mCardNullPolymericData != null) {
            this.lmv.add(this.mCardNullPolymericData);
        }
        if (!y.isEmpty(this.lmu)) {
            this.lmv.addAll(this.lmu);
        }
    }
}
