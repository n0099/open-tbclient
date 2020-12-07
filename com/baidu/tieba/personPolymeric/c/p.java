package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.y;
/* loaded from: classes24.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dAu() {
        this.mrx.clear();
        if (this.mCardNullPolymericData != null) {
            this.mrx.add(this.mCardNullPolymericData);
        }
        if (!y.isEmpty(this.mrw)) {
            this.mrx.addAll(this.mrw);
        }
    }
}
