package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bfw() {
        this.fJZ.clear();
        if (this.mCardNullPolymericData != null) {
            this.fJZ.add(this.mCardNullPolymericData);
        }
        if (!v.w(this.fKb)) {
            this.fJZ.addAll(this.fKb);
        }
        if (!v.w(this.fJY)) {
            this.fJZ.addAll(this.fJY);
        }
    }
}
