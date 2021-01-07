package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.x;
/* loaded from: classes8.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dAl() {
        this.mwM.clear();
        if (this.mCardNullPolymericData != null) {
            this.mwM.add(this.mCardNullPolymericData);
        }
        if (!x.isEmpty(this.mwL)) {
            this.mwM.addAll(this.mwL);
        }
    }
}
