package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes11.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cIe() {
        this.kay.clear();
        if (this.mCardNullPolymericData != null) {
            this.kay.add(this.mCardNullPolymericData);
        }
        if (!v.isEmpty(this.kax)) {
            this.kay.addAll(this.kax);
        }
    }
}
