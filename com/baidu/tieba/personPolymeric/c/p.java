package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bfw() {
        this.fJW.clear();
        if (this.mCardNullPolymericData != null) {
            this.fJW.add(this.mCardNullPolymericData);
        }
        if (!v.w(this.fJY)) {
            this.fJW.addAll(this.fJY);
        }
        if (!v.w(this.fJV)) {
            this.fJW.addAll(this.fJV);
        }
    }
}
