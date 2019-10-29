package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cbh() {
        this.isg.clear();
        if (this.mCardNullPolymericData != null) {
            this.isg.add(this.mCardNullPolymericData);
        }
        if (!v.isEmpty(this.isi)) {
            this.isg.addAll(this.isi);
        }
        if (!v.isEmpty(this.isf)) {
            this.isg.addAll(this.isf);
        }
    }
}
