package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.x;
/* loaded from: classes8.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dAk() {
        this.mwN.clear();
        if (this.mCardNullPolymericData != null) {
            this.mwN.add(this.mCardNullPolymericData);
        }
        if (!x.isEmpty(this.mwM)) {
            this.mwN.addAll(this.mwM);
        }
    }
}
