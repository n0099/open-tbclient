package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void brL() {
        this.gBI.clear();
        if (this.mCardNullPolymericData != null) {
            this.gBI.add(this.mCardNullPolymericData);
        }
        if (!v.I(this.gBK)) {
            this.gBI.addAll(this.gBK);
        }
        if (!v.I(this.gBH)) {
            this.gBI.addAll(this.gBH);
        }
    }
}
