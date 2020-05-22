package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes11.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cPe() {
        this.ksq.clear();
        if (this.mCardNullPolymericData != null) {
            this.ksq.add(this.mCardNullPolymericData);
        }
        if (!v.isEmpty(this.ksp)) {
            this.ksq.addAll(this.ksp);
        }
    }
}
