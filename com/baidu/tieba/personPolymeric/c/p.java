package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bfw() {
        this.fLc.clear();
        if (this.mCardNullPolymericData != null) {
            this.fLc.add(this.mCardNullPolymericData);
        }
        if (!v.w(this.fLe)) {
            this.fLc.addAll(this.fLe);
        }
        if (!v.w(this.fLb)) {
            this.fLc.addAll(this.fLb);
        }
    }
}
