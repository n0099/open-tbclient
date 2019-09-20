package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cef() {
        this.itG.clear();
        if (this.mCardNullPolymericData != null) {
            this.itG.add(this.mCardNullPolymericData);
        }
        if (!v.aa(this.itI)) {
            this.itG.addAll(this.itI);
        }
        if (!v.aa(this.itF)) {
            this.itG.addAll(this.itF);
        }
    }
}
