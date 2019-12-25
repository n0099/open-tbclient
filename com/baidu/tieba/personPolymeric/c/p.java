package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes8.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cuy() {
        this.jjR.clear();
        if (this.mCardNullPolymericData != null) {
            this.jjR.add(this.mCardNullPolymericData);
        }
        if (!v.isEmpty(this.jjQ)) {
            this.jjR.addAll(this.jjQ);
        }
    }
}
