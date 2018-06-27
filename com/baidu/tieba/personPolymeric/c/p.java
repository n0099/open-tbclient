package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.w;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bla() {
        this.gao.clear();
        if (this.mCardNullPolymericData != null) {
            this.gao.add(this.mCardNullPolymericData);
        }
        if (!w.A(this.gaq)) {
            this.gao.addAll(this.gaq);
        }
        if (!w.A(this.gan)) {
            this.gao.addAll(this.gan);
        }
    }
}
