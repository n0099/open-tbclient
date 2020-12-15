package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.y;
/* loaded from: classes24.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dAv() {
        this.mrz.clear();
        if (this.mCardNullPolymericData != null) {
            this.mrz.add(this.mCardNullPolymericData);
        }
        if (!y.isEmpty(this.mry)) {
            this.mrz.addAll(this.mry);
        }
    }
}
